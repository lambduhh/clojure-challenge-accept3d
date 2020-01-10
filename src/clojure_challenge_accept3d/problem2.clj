(ns clojure-challenge-accept3d.problem2)



(defn maxdifference [nums]
  (if (= 1 (count nums))
    -1
    (let [[head & tail] nums
          smallest (apply min tail)]
      (if (< smallest head)
        (max (- head smallest)
             (maxdifference (rest nums)))
        (maxdifference (rest nums))))))


(defn maxDifference [nums]
  (let [nums (reverse nums)]
    (maxdifference nums)))



(comment

  (maxDifference [1 2 3 4 5])
  (maxDifference [7 5 3 1])
  (maxDifference [7 1 2 5])

  )