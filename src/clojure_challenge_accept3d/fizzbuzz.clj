(ns clojure-challenge-accept3d.fizzbuzz)


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

(comment
  (fizzbuzz 15)
  (def i 5)
  )