(ns clojure-challenge-accept3d.fizzbuzz)

;; first implementation of fizzbuzz
(defn div-by-5-and-3 [n]
  (if (and (zero? (rem n 3)) (zero? (rem n 5)))
    true))

(defn fizzbuzz [n]
  (doseq [i (range 1 (inc n))]
    (cond
      (div-by-5-and-3 i) (println "FizzBuzz")
      (zero? (rem i 3)) (println "Fizz")
      (zero? (rem i 5)) (println "Buzz")
      :else (println i)
      )))
;; ran code in HR but failed 2 test cases based on code "running too slow"?


;; second implementation to fizzbuzz to test if I would receive the same failures (test cases 6 and 7)
(defn fizzbuzz1 [n]
  (doseq [i (range 1 (inc n))]
    (case [(zero? (rem i 3)) (zero? (rem i 5))]
      [false false] (println i)
      [true false] (println "Fizz")
      [false true] (println "Buzz")
      [true true] (println "FizzBuzz"))))
;; same failures on cases 6 and 7

(comment
  (fizzbuzz 15)

  (time (fizzbuzz1 10e5))
  (def i 5)
  )