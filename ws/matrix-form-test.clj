;; gorilla-repl.fileformat = 1

;; **
;;; # Thinking about core.matrix rendering
;;; 
;;; Gorilla's renderer at the moment works by dispatching the render call on type. How might this work with core.matrix, and other things that are defined by _protocol_?
;;; 
;;; One idea, sketched out in this worksheet is to use a view-function, much like is done in Mathematica. Internally it will work by wrapping the matrix in a marker type, but this should be viewed as an implementation detail.
;;; 
;;; In Mathematica, matrices are represented by lists-of-lists, and on the whole, the notebook doesn't do anything special with them, displaying them like flat lists-of-lists. There'a a function, `MatrixForm` whose job is to tag the data for display in the front end as a matrix.
;;; 
;;; ### Implementation
;;; 
;;; We'll start with the implementation - skip below to see how it looks from the user perspective.
;; **

;; @@
(ns matrix-form-test
  (use clojure.core.matrix)
  (use gorilla-renderable.core))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; This type is just a marker for the front end, to know to render its contents as a matrix.
;; **

;; @@
(defrecord MatrixView [contents])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-class'>matrix_form_test.MatrixView</span>","value":"matrix_form_test.MatrixView"}
;; <=

;; **
;;; A helper function, and an `extend-type` call (which at the minute are straight stolen from the table renderer, so you'll have to use your imagination on the formatting) tell Gorilla how to render things tagged as `MatrixView`. These rendering functions would work using protocol methods, meaning it would work for any implementation.
;; **

;; @@
(defn list-like
  [data value open close separator]
  {:type :list-like
   :open open
   :close close
   :separator separator
   :items data
   :value value})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;matrix-form-test/list-like</span>","value":"#'matrix-form-test/list-like"}
;; <=

;; @@
(extend-type MatrixView
  Renderable
  (render [self]
    (let [contents (:contents self)
          rows (map (fn [r] (list-like (map render r) 
                                       (pr-str r) "<tr><td>" "</td></tr>" "</td><td>")) contents)
          body (list-like rows 
                          (pr-str self) "<center><table>" "</table></center>" "\n")]
      body)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; And then, finally the user-facing function, which from their perspective, shows the given object as a matrix.
;; **

;; @@
(defn matrix-view [i] (MatrixView. i))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;matrix-form-test/matrix-view</span>","value":"#'matrix-form-test/matrix-view"}
;; <=

;; **
;;; ### User perspective
;;; 
;;; The user can define a matrix:
;; **

;; @@
(def i (matrix [[1 2 5] [3 4 5] [1 2 1]]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;matrix-form-test/i</span>","value":"#'matrix-form-test/i"}
;; <=

;; **
;;; And if they look at it, it will be faithfully rendered according to the underlying implementation. This is kind of nice in a way, as you can really see what's going on.
;; **

;; @@
i
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"[1 2 5]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"[3 4 5]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"[1 2 1]"}],"value":"[[1 2 5] [3 4 5] [1 2 1]]"}
;; <=

;; **
;;; But, if you want to look at it as a matrix, then you can put it in to `matrix-view`.
;; **

;; @@
(matrix-view i)
;; @@
;; =>
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"[1 2 5]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"[3 4 5]"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"[1 2 1]"}],"value":"#matrix_form_test.MatrixView{:contents [[1 2 5] [3 4 5] [1 2 1]]}"}
;; <=

;; @@

;; @@
