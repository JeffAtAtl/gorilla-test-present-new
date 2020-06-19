;; gorilla-repl.fileformat = 1

;; **
;;; # SICP - 1.0 Building Abstractions with Procedures
;; **

;; @@
(ns sicp-1)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; ##1.1 The Elements of Programming
;;; ###1.1.1 Expressions
;; **

;; @@
486
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>486</span>","value":"486"}
;; <=

;; @@
(+ 137 349)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>486</span>","value":"486"}
;; <=

;; @@
(- 1000 334)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>666</span>","value":"666"}
;; <=

;; @@
(* 5 99)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>495</span>","value":"495"}
;; <=

;; @@
(/ 10 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
(+ 2.7 10)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>12.7</span>","value":"12.7"}
;; <=

;; @@
(+ 21 35 12 7)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>75</span>","value":"75"}
;; <=

;; @@
(* 25 4 12)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1200</span>","value":"1200"}
;; <=

;; @@
(+ (* 3 5) (- 10 6))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>19</span>","value":"19"}
;; <=

;; @@
(+ (* 3 (+ (* 2 4) (+ 3 5))) (+ (- 10 7) 6))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>57</span>","value":"57"}
;; <=

;; @@
(+ (* 3 
      (+ (* 2 4) 
         (+ 3 5))) 
   (+ (- 10 7) 
      6))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>57</span>","value":"57"}
;; <=

;; **
;;; ###1.1.2 Naming and the Environment
;; **

;; @@
(def size 2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/size</span>","value":"#'sicp-1/size"}
;; <=

;; @@
size
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
(* 5 size)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>10</span>","value":"10"}
;; <=

;; @@
(def pi 3.14159)
(def radius 10)  
(* pi (* radius radius))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>314.159</span>","value":"314.159"}
;; <=

;; @@
(def circumference (* 2 pi radius))  
circumference
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>62.8318</span>","value":"62.8318"}
;; <=

;; **
;;; ###1.1.3 Evaluating Combinations
;; **

;; @@
                ;; 390
(* (+ 2         ;; 26
      (* 4 6))  ;; 24
   (+ 3 5 7))   ;; 15
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>390</span>","value":"390"}
;; <=

;; **
;;; ###1.1.4 Compound Procedures
;; **

;; @@
(defn square [x] (* x x))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;test/square</span>","value":"#'test/square"}
;; <=

;; @@
(square 21)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>441</span>","value":"441"}
;; <=

;; @@
(square (+ 2 5))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>49</span>","value":"49"}
;; <=

;; @@
(square (square 3))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>81</span>","value":"81"}
;; <=

;; **
;;; We can also use square as a building block in defining other procedures. For example, $$ x^{2} + y^{2} $$ can be expressed as
;;; 
;;; (+ (square x) (square y))
;; **

;; @@
(defn sum-of-squares [x y]  
  (+ (square x) (square y)))  
  
(sum-of-squares 3 4)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>25</span>","value":"25"}
;; <=

;; @@
(defn f [a]  
  (sum-of-squares (+ a 1) (* a 2)))  
  
(f 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>136</span>","value":"136"}
;; <=

;; **
;;; ###1.1.5 The Substitution Model for Procedure Application
;; **

;; @@
(f 5)

(sum-of-squares (+ 5 1) (* 5 2))  
  
(+    (square (+ 5 1))      (square (* 5 2)))  
  
(+    (* (+ 5 1) (+ 5 1))   (* (* 5 2) (* 5 2)))

(+         (* 6 6)             (* 10 10))  

(+           36                   100)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>136</span>","value":"136"}
;; <=

;; **
;;; ###1.1.6 Conditional Expressions and Predicates
;; **

;; @@
(defn abs [x]
  (cond (> x 0) x
        (= x 0) 0
        (< x 0) (- x)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/abs</span>","value":"#'sicp-1/abs"}
;; <=

;; @@
(abs -2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
(defn abs [x]  
  (cond (< x 0) (- x)  
        :else x))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/abs</span>","value":"#'sicp-1/abs"}
;; <=

;; @@
(abs -2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
(defn abs [x]  
  (if (< x 0)
    (- x)
    x))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;test/abs</span>","value":"#'test/abs"}
;; <=

;; @@
(abs -2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; **
;;; As an example of how these are used, the condition that a number x be in the range (5 < x < 10) may be expressed as
;;; 
;;; (and (> x 5) (< x 10))
;; **

;; @@
(defn >= [x y]  
  (or (> x y) (= x y)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/&gt;=</span>","value":"#'sicp-1/>="}
;; <=

;; @@
(defn >= [x y]  
  (not (< x y)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/&gt;=</span>","value":"#'sicp-1/>="}
;; <=

;; **
;;; ####Exercise 1.1. 
;;; 
;;; Below is a sequence of expressions. What is the result printed by the interpreter in response to each expression? Assume that the sequence is to be evaluated in the order in which it is presented.
;; **

;; @@
10  
(+ 5 3 4)  
(- 9 1)  
(/ 6 2)  
(+ (* 2 4) (- 4 6))  
(def a 3)  
(def b (+ a 1))  
(+ a b (* a b))  
(= a b)  
(if (and (> b a) (< b (* a b)))  
    b  
    a)  
(cond (= a 4) 6  
      (= b 4) (+ 6 7 a)  
      :else 25)  
(+ 2 (if (> b a) b a))  
(* (cond (> a b) a  
         (< a b) b  
         :else -1)  
   (+ a 1))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>16</span>","value":"16"}
;; <=

;; **
;;; ####Exercise 1.2. 
;;; 
;;; Translate the following expression into prefix form:
;;; 
;;; $$ \frac{5 + 4 + ( 2 - (3 - (6 +\tfrac{4}{5})))}{3(6-2)(2-7)} $$
;; **

;; @@
(/ (+ 5 
      4
      (- 2 
         (- 3 
            (+ 6
               (/ 4 5)))))
   (* 3
      (- 6 2)
      (- 2 7)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-ratio'>-37/150</span>","value":"-37/150"}
;; <=

;; **
;;; ####Exercise 1.3. 
;;; 
;;; Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.
;; **

;; @@
;; this uses previous functions and all I know about clojure
(defn f [a b c]
  (apply sum-of-squares (drop 1 (sort (list a b c)))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/f</span>","value":"#'sicp-1/f"}
;; <=

;; @@
(f 5 4 3)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>41</span>","value":"41"}
;; <=

;; @@
;; this uses only what has been defined so far
(defn f1 [a b c]
  (sum-of-squares (if (or (< b a) (< c a)) 
                      a
                      (if (or (< a b) (< c b))
                          b
                          c))
                  (if (or (< a c) (< b c))
                      c
                      (if (or (< a b) (< c b))
                          b
                          a))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/f1</span>","value":"#'sicp-1/f1"}
;; <=

;; @@
(f1 4 5 3)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>41</span>","value":"41"}
;; <=

;; **
;;; ####Exercise 1.4. 
;;; 
;;; Observe that our model of evaluation allows for combinations whose operators are compound expressions. Use this observation to describe the behavior of the following procedure:
;; **

;; @@
(defn a-plus-abs-b [a b]  
  ((if (> b 0) + -) a b))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/a-plus-abs-b</span>","value":"#'sicp-1/a-plus-abs-b"}
;; <=

;; @@
[(a-plus-abs-b 2 -2)
 (a-plus-abs-b 2 2)]
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}],"value":"[4 4]"}
;; <=

;; **
;;; ####Exercise 1.5. 
;;; 
;;; Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with is using applicative-order evaluation or normal-order evaluation. He defines the following two procedures:
;; **

;; @@
(defn p [] (p))  
  
(defn tst [x y]  
  (if (= x 0)  
      0  
      y)) 
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/tst</span>","value":"#'sicp-1/tst"}
;; <=

;; @@
(tst 0 (p))
;; @@

;; **
;;; ###1.1.7 Example: Square Roots by Newton's Method
;; **

;; **
;;; Procedures, as introduced above, are much like ordinary mathematical functions. They specify a value that is determined by one or more parameters. But there is an important difference between mathematical functions and computer procedures. Procedures must be effective.
;;; 
;;; As a case in point, consider the problem of computing square roots. We can define the square-root function as
;;; 
;;; $$ \sqrt{x} = \text{the } y \text{ such that } y \geq 0 \text{ and } y^{2}=x $$
;;; 
;;; This describes a perfectly legitimate mathematical function. We could use it to recognize whether one number is the square root of another, or to derive facts about square roots in general. On the other hand, the definition does not describe a procedure. Indeed, it tells us almost nothing about how to actually find the square root of a given number. It will not help matters to rephrase this definition in pseudo-Lisp:
;; **

;; @@
(defn sqrt [x]  
  (the y (and (>= y 0)  
              (= (square y) x))))
;; @@

;; @@
(defn average [x y]  
  (/ (+ x y) 2))

(defn improve [guess x]  
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (println guess)
  (< (abs (- (square guess) x)) 0.0000000000001))

(defn sqrt-iter [guess x]  
  (if (good-enough? guess x)  
      guess  
      (sqrt-iter (improve guess x)  
                 x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/sqrt</span>","value":"#'sicp-1/sqrt"}
;; <=

;; @@
(sqrt 0.000002)
;; @@
;; ->
;;; 1.0
;;; 0.500001
;;; 0.25000249999600005
;;; 0.1250052499580005
;;; 0.06251062464301704
;;; 0.0312713096020622
;;; 0.01566763299486837
;;; 0.00789764234785636
;;; 0.0040754412405195
;;; 0.0022830928243925542
;;; 0.0015795487524060156
;;; 0.001422866579578668
;;; 0.0014142398735915306
;;; 0.0014142135626178485
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-double'>0.0014142135626178485</span>","value":"0.0014142135626178485"}
;; <=

;; @@
(sqrt (sum-of-squares 3 4))
;; @@
;; ->
;;; 1.0
;;; 13.0
;;; 7.461538461538462
;;; 5.406026962727994
;;; 5.015247601944898
;;; 5.000023178253949
;;; 5.000000000053722
;;; 5.0
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-double'>5.0</span>","value":"5.0"}
;; <=

;; **
;;; ####Exercise 1.6. 
;;; 
;;; Alyssa P. Hacker doesn't see why if needs to be provided as a special form. "Why can't I just define it as an ordinary procedure in terms of cond?" she asks. Alyssa's friend Eva Lu Ator claims this can indeed be done, and she defines a new version of if:
;; **

;; @@
(defn new-if [predicate then-clause else-clause]  
  (cond predicate then-clause  
        :else else-clause))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/new-if</span>","value":"#'sicp-1/new-if"}
;; <=

;; @@
(new-if (= 2 3) 0 5) 
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}
;; <=

;; @@
(new-if (= 1 1) 0 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>0</span>","value":"0"}
;; <=

;; **
;;; Delighted, Alyssa uses new-if to rewrite the square-root program:
;; **

;; @@
(defn good-enough-1? [guess x]
  (< (abs (- (square guess) x)) 0.0000000000001))

(defn sqrt-iter-1 [guess x]  
  (new-if (good-enough-1? guess x)  
      guess  
      (sqrt-iter-1 (improve guess x)  
                 x)))

(defn sqrt-1 [x]
  (sqrt-iter-1 1.0 x))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sicp-1/sqrt-1</span>","value":"#'sicp-1/sqrt-1"}
;; <=

;; @@
(- (sqrt 5) (sqrt-1 5))
;; @@

;; **
;;; ####Exercise 1.7. 
;;; 
;;; The good-enough? test used in computing square roots will not be very effective for finding the square roots of very small numbers. Also, in real computers, arithmetic operations are almost always performed with limited precision. This makes our test inadequate for very large numbers. Explain these statements, with examples showing how the test fails for small and large numbers. An alternative strategy for implementing good-enough? is to watch how guess changes from one iteration to the next and to stop when the change is a very small fraction of the guess. Design a square-root procedure that uses this kind of end test. Does this work better for small and large numbers?
;; **

;; @@
(sqrt 0.01)
;; @@
;; ->
;;; 1.0
;;; 0.505
;;; 0.2624009900990099
;;; 0.15025530119986813
;;; 0.10840434673026925
;;; 0.10032578510960605
;;; 0.10000052895642693
;;; 0.10000000000139897
;;; 0.1
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-double'>0.1</span>","value":"0.1"}
;; <=

;; @@

;; @@

;; **
;;; ####Exercise 1.8. 
;;; 
;;; Newton's method for cube roots is based on the fact that if y is an approximation to the cube root of x, then a better approximation is given by the value:
;;; 
;;; $$ \frac{x/y^{2}+ 2y}{3} $$
;;; 
;;; Use this formula to implement a cube-root procedure analogous to the square-root procedure. (In section 1.3.4 we will see how to implement Newton's method in general as an abstraction of these square-root and cube-root procedures.)
;; **

;; @@
(def guesses (atom []))

(defn reset [a] [])

(defn cube [x] (* x x x))

(defn average [x y]  
  (/ (+ x y) 2))

(defn improve-cube [guess x]  
  (average guess (/ (+ (/ x (square guess)) 
                       (* 2 guess)) 
                    3)))

(defn good-enough-cube? [guess x]
  (swap! guesses conj guess)
  (< (abs (- (cube guess) x)) 0.0001))

(defn cube-rt-iter [guess x]  
  (if (good-enough-cube? guess x)  
      [guess @guesses (count @guesses)]
      (cube-rt-iter (improve-cube guess x)  
                 x)))

(defn cube-rt [x]
  (swap! guesses reset)
  (cube-rt-iter 1.0 x))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;test/cube-rt</span>","value":"#'test/cube-rt"}
;; <=

;; @@
(cube-rt 64)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>4.000001110815228</span>","value":"4.000001110815228"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>1.0</span>","value":"1.0"},{"type":"html","content":"<span class='clj-double'>11.5</span>","value":"11.5"},{"type":"html","content":"<span class='clj-double'>9.66398865784499</span>","value":"9.66398865784499"},{"type":"html","content":"<span class='clj-double'>8.167536976552562</span>","value":"8.167536976552562"},{"type":"html","content":"<span class='clj-double'>6.966180092606427</span>","value":"6.966180092606427"},{"type":"html","content":"<span class='clj-double'>6.024955968275684</span>","value":"6.024955968275684"},{"type":"html","content":"<span class='clj-double'>5.314643442481838</span>","value":"5.314643442481838"},{"type":"html","content":"<span class='clj-double'>4.806511681702622</span>","value":"4.806511681702622"},{"type":"html","content":"<span class='clj-double'>4.467135804388524</span>","value":"4.467135804388524"},{"type":"html","content":"<span class='clj-double'>4.257141112274293</span>","value":"4.257141112274293"},{"type":"html","content":"<span class='clj-double'>4.136180152811593</span>","value":"4.136180152811593"},{"type":"html","content":"<span class='clj-double'>4.07030728007468</span>","value":"4.07030728007468"},{"type":"html","content":"<span class='clj-double'>4.0357573601183585</span>","value":"4.0357573601183585"},{"type":"html","content":"<span class='clj-double'>4.018036619763166</span>","value":"4.018036619763166"},{"type":"html","content":"<span class='clj-double'>4.009058731722638</span>","value":"4.009058731722638"},{"type":"html","content":"<span class='clj-double'>4.004539592552768</span>","value":"4.004539592552768"},{"type":"html","content":"<span class='clj-double'>4.0022723683714965</span>","value":"4.0022723683714965"},{"type":"html","content":"<span class='clj-double'>4.001136829154442</span>","value":"4.001136829154442"},{"type":"html","content":"<span class='clj-double'>4.000568576063591</span>","value":"4.000568576063591"},{"type":"html","content":"<span class='clj-double'>4.000284328433981</span>","value":"4.000284328433981"},{"type":"html","content":"<span class='clj-double'>4.000142174321365</span>","value":"4.000142174321365"},{"type":"html","content":"<span class='clj-double'>4.000071089687255</span>","value":"4.000071089687255"},{"type":"html","content":"<span class='clj-double'>4.000035545475331</span>","value":"4.000035545475331"},{"type":"html","content":"<span class='clj-double'>4.000017772895599</span>","value":"4.000017772895599"},{"type":"html","content":"<span class='clj-double'>4.000008886487284</span>","value":"4.000008886487284"},{"type":"html","content":"<span class='clj-double'>4.000004443253513</span>","value":"4.000004443253513"},{"type":"html","content":"<span class='clj-double'>4.000002221629224</span>","value":"4.000002221629224"},{"type":"html","content":"<span class='clj-double'>4.000001110815228</span>","value":"4.000001110815228"}],"value":"[1.0 11.5 9.66398865784499 8.167536976552562 6.966180092606427 6.024955968275684 5.314643442481838 4.806511681702622 4.467135804388524 4.257141112274293 4.136180152811593 4.07030728007468 4.0357573601183585 4.018036619763166 4.009058731722638 4.004539592552768 4.0022723683714965 4.001136829154442 4.000568576063591 4.000284328433981 4.000142174321365 4.000071089687255 4.000035545475331 4.000017772895599 4.000008886487284 4.000004443253513 4.000002221629224 4.000001110815228]"},{"type":"html","content":"<span class='clj-unkown'>28</span>","value":"28"}],"value":"[4.000001110815228 [1.0 11.5 9.66398865784499 8.167536976552562 6.966180092606427 6.024955968275684 5.314643442481838 4.806511681702622 4.467135804388524 4.257141112274293 4.136180152811593 4.07030728007468 4.0357573601183585 4.018036619763166 4.009058731722638 4.004539592552768 4.0022723683714965 4.001136829154442 4.000568576063591 4.000284328433981 4.000142174321365 4.000071089687255 4.000035545475331 4.000017772895599 4.000008886487284 4.000004443253513 4.000002221629224 4.000001110815228] 28]"}
;; <=

;; **
;;; ###1.1.8 Procedures as Black-Box Abstractions
;; **

;; @@
(defn sqrt [x]  
  (defn good-enough? [guess x]  
    (< (abs (- (square guess) x)) 0.001))  
  (defn improve [guess x]  
    (average guess (/ x guess)))  
  (defn sqrt-iter [guess x]  
    (if (good-enough? guess x)  
        guess  
        (sqrt-iter (improve guess x) x)))  
  (sqrt-iter 1.0 x))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;test/sqrt</span>","value":"#'test/sqrt"}
;; <=

;; @@
(sqrt 64)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>8.000001655289593</span>","value":"8.000001655289593"}
;; <=

;; @@
(defn sqrt [x]  
  (defn abs [n]  
  (if (< n 0)
    (- n)
    n))
  (defn square [n] (* n n))
  (defn average [n m]  
  (/ (+ n m) 2))
  (defn good-enough? [guess]  
    (< (abs (- (square guess) x)) (/ guess 10000000000000)))  
  (defn improve [guess] 
    (average guess (/ x guess)))  
  (defn sqrt-iter [guess]  
    (println guess)
    (if (good-enough? guess)  
        guess  
        (sqrt-iter (improve guess))))
  (defn first-guess [n]
        (cond
          (> n 50000000000000) 10000000.0
          (> n 500000000000) 1000000.0
          (> n 5000000000) 100000.0
          (> n 50000000) 10000.0
          (> n 500000) 1000.0
          (> n 5000) 100.0
          (>= n 50) 10.0
          (< n 0.0000000000005) 0.0000001
          (< n 0.00000000005) 0.000001
          (< n 0.000000005) 0.00001
          (< n 0.0000005) 0.0001
          (< n 0.00005) 0.001
          (< n 0.005) 0.01
          (< n 0.5) 0.1
          (< n 50) 1.0
          ))
  (sqrt-iter (first-guess x)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;user/sqrt</span>","value":"#'user/sqrt"}
;; <=

;; @@
(sqrt 0.00000000000004)
;; @@
;; ->
;;; 1.0E-7
;;; 2.5000000000000004E-7
;;; 2.05E-7
;;; 2.000609756097561E-7
;;; 2.0000000929222946E-7
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-double'>2.0000000929222946E-7</span>","value":"2.0000000929222946E-7"}
;; <=

;; @@
(System/getProperty "java.version")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;1.7.0_79&quot;</span>","value":"\"1.7.0_79\""}
;; <=

;; @@

;; @@
