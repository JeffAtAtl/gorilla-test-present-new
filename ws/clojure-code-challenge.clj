;; gorilla-repl.fileformat = 1

;; **
;;; # Clojure Code Challenge
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns clojure-code-challenge
  (:use clojure.test))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; ##Instructions
;;; 
;;; There are no time constraints, you can spend as much or as little time as you want on these problems. You are welcome to submit incomplete answers or pseudo-code, but please try to complete at least one of the coding problems so we have something to work with in a follow-up interview. A complete solution to one problem is better than an incomplete solution to both. I’ve added a rationale in each section to help you understand why I’m asking these questions and what I’m looking for in your responses.
;;; 
;;; You can submit your answers as another gist, an email attachment, or whatever you’re comfortable with.
;;; 
;;; ###Code Review
;;; 
;;; Take a look at the following Clojure code
;; **

;; @@
(let
  [check (fn [& sets] 
    (first (filter #(not (nil? %))
      (map
        (fn [ss]
          (let [r (first (filter #(or (= % #{:x}) (= % #{:o})) ss))]
            (if r (first r) nil)))
        sets))))]

  (defn ttt [board]
    (check
      (map set board)
      (map set (apply map list board))
      (list (set (map #(nth (nth board %) %) (range 3))))
      (list (set (map #(nth (nth board %) (- 2 %)) (range 3))))
)))

(assert (= :x (ttt [[:x :o :x] [:x :o :o] [:x :x :o]])))
(assert (= :o (ttt [[:o :x :x] [:x :o :x] [:x :o :o]])))
(assert (nil? (ttt [[:x :o :x] [:x :o :x] [:o :x :o]])))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;;  1. What is the code trying to accomplish?
;;;  
;;;  Determine the winner on a tic-tac-toe game board, if there is one.
;;;  
;;;  2. Describe at a high level how it works.
;;;  
;;;   1. check if board has any:
;;;    three in a row (map set across each row), three in a column. (change columns to rows and map set across each row), three in a upper left to lower right diaginal. (), three in a upper right to lower left diaginal.
;;;   2. combine into one answer returning :x, :o or nil
;;;  
;;;  3. What feedback would you provide in a code review?
;;;  
;;;  I would either put more comments or decompose it into well named functions. Remove the let and define check as named function. Make use of threading macro to make the code more readable. Also add document strings to all defined functions.
;;;  
;;;  I like the assertions in the code that allow for in-line run-time testing.
;;;  
;;;  4. (Bonus) How would you write it?
;; **

;; @@
(defn filter-3-in-a-row
  "Find sets with one member, signifying that you have three in a row."
  [ss]
  (->> ss
       (filter #(or (= % #{:x}) (= % #{:o})))
       first
       (#(if % (first %) nil))))

(defn check 
  "Apply filter-3-in-a-row to all lists of sets."
  [& sets] 
  (->> sets
       (map filter-3-in-a-row)
       (filter #(not (nil? %)))
       first))

(defn ttt [board]
  "Get winner for tic-tac-toe board."
    (check
      (map set board)
      (map set (apply map list board))
      (list (set (map #(nth (nth board %) %) (range 3))))
      (list (set (map #(nth (nth board %) (- 2 %)) (range 3))))))

(assert (= :x (ttt [[:x :o :x] [:x :o :o] [:x :x :o]])))
(assert (= :o (ttt [[:o :x :x] [:x :o :x] [:x :o :o]])))
(assert (nil? (ttt [[:x :o :x] [:x :o :x] [:o :x :o]])))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; ###Code Writing 1
;;; 
;;; Android has a pattern lock screen with 9 dots:
;;; 
;;; 1 2 3
;;; 
;;; 4 5 6
;;; 
;;; 7 8 9
;;; 
;;; Dots may be connected in any order, but:
;;; 
;;; Each dot may only be used once
;;; Dots must be connected with straight lines
;;; A dot may not be crossed without being used
;;; Task
;;; 
;;; Write a function in any language that takes a sequence of numbers representing dots to connect and determines if it represents a valid pattern.
;;; 
;;; Clojure test cases
;; **

;; @@
(is (true?  (valid-path [1 6 7 4])))   ;; knights jump is valid

(is (true?  (valid-path [2 1 3])))     ;; 2 is already used, so we can cross it

(is (false? (valid-path [1 3 2])))     ;; can't get from 1 to 3 without using 2 first

(is (false? (valid-path [1 9])))       ;; can't cross 5 without using

(is (false? (valid-path [1 2 3 2 1]))) ;; can't use dots more than once

(is (false? (valid-path [0 1 2 3])))   ;; there's no dot 0
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(defn valid-numbers?
  "validate against set of valid numbers"
  [p]
  (= (count p) (count (filter #{1 2 3 4 5 6 7 8 9} p))))

(defn no-dup?
  "No duplicates"
  [p]
  (= 1 (apply max (vals (frequencies p)))))

(defn no-crossed-digits?
  "No crossed digits, unless already used."
  [p]
  (let [pairs (partition 2 1 p)
        cross-pairs #{[1 3] [3 1] [1 9] [9 1] [1 7] [7 1] [2 8] [8 2] [3 9] [9 3] [4 6] [6 4] [7 9] [9 7]}
        crossed-pairs-in-pairs (filter cross-pairs pairs)
        pairs-index-map (apply zipmap (reverse (apply map list (map-indexed vector pairs))))
        p-index-map (apply zipmap (reverse (apply map list (map-indexed vector p))))
        crossed-lkup {[1 3] 2 [3 1] 2 [1 9] 5 [9 1] 5 [1 7] 4 [7 1] 4 [2 8] 5 [8 2] 5 [3 9] 6 [9 3] 6 [4 6] 5 [6 4] 5 [7 9] 8 [9 7] 8}
        ]
    (= 0 
       (->> crossed-pairs-in-pairs
            (remove #(< (if (nil? (p-index-map (crossed-lkup %)))
                              9 
                              (p-index-map (crossed-lkup %)))
                        (pairs-index-map %)))
            count))))

(defn valid-path
  "Is valid path"
  [p]
  (and (valid-numbers? p) 
       (no-dup? p) 
       (no-crossed-digits? p))
  )
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojure-code-challenge/valid-path</span>","value":"#'clojure-code-challenge/valid-path"}
;; <=

;; **
;;; ####Bonus questions (please explain answers)
;;; 
;;; Given a PIN entered with a 9-digit keypad instead, how many digits would be required to have more possible combinations than the pattern lock?
;;; 
;;; 
;;; 
;;; If the grid can be extended to any square size (ex 4x4), but the pattern can only have up to 8 dots, what’s the smallest size at which there would be as many possibilities as an 8 character alphanumeric (a-z, A-Z, 0-9) password?
;;; 
;;; ####Rationale
;;; 
;;; The goal here is just to see how you approach this problem and provide something with many directions to go in a follow up pairing session. Are you a BDD enthusiast who will write the minimum possible code to meet these exact requirements? Or maybe you are a forward-thinker who will generalize to make future changes easier? There are no right answers, just different tradeoffs. No gotchas or fancy algorithms needed, just write some code.
;;; 
;;; 
;;; ###Code Writing 2
;;; 
;;; Write a function in any language that takes a matrix of characters and a word, and returns the number of times that word appears in the matrix. The word may appear left-to-right, right-to-left, top-to-bottom, or bottom-to-top.
;;; 
;;; Example
;;; 
;;; A O T D L R O W   
;;; 
;;; L C B M U M L U   
;;; 
;;; D R U J D B L J   
;;; 
;;; P A Z H Z Z E F   
;;; 
;;; B C Z E L F H W   
;;; 
;;; R K U L V P P G   
;;; 
;;; A L B L P O P Q   
;;; 
;;; B E M O P P J Y 
;;; 
;;; Clojure test cases
;; **

;; @@
(is (= 2 (count-words-in-matrix mat "HELLO")))

(is (= 1 (count-words-in-matrix mat "WORLD")))

(is (= 2 (count-words-in-matrix mat "BUZZ")))

(is (= 0 (count-words-in-matrix mat "CLOJURE")))

(is (= 0 (count-words-in-matrix mat "COWABUNGA")))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(def mat [[\A \O \T \D \L \R \O \W] 
          [\L \C \B \M \U \M \L \U] 
          [\D \R \U \J \D \B \L \J] 
          [\P \A \Z \H \Z \Z \E \F] 
          [\B \C \Z \E \L \F \H \W] 
          [\R \K \U \L \V \P \P \G] 
          [\A \L \B \L \P \O \P \Q] 
          [\B \E \M \O \P \P \J \Y]])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojure-code-challenge/mat</span>","value":"#'clojure-code-challenge/mat"}
;; <=

;; @@
(defn count-words-in-matrix
  "Takes a matrix of characters and a word, and returns the number of times that word appears in the matrix."
  [m w]
  (let [ms (map #(apply str %) m)
        mr (apply map (comp reverse list) m)
        mrs (map #(apply str %) mr)
        mr2 (apply map (comp reverse list) mr)
        mr2s (map #(apply str %) mr2)
        mr3 (apply map (comp reverse list) mr2)
        mr3s (map #(apply str %) mr3)]
    (->> (concat ms mrs mr2s mr3s)
         (map #(.contains % w))
         (remove false?)
         count)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojure-code-challenge/count-words-in-matrix</span>","value":"#'clojure-code-challenge/count-words-in-matrix"}
;; <=

;; **
;;; ####Rationale
;;; 
;;; This is another simple problem just to give us some code to work with. 
;;; 
;;; Do you see the parallels with the previous problem? 
;;; 
;;; Not really.
;;; 
;;; Will you solve more than is actually be asked?
;;; 
;;; No.
;; **
