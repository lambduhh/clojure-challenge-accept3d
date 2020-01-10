(ns clojure-challenge-accept3d.problem2)

(declare maxDifference)


(defn diffnums [n xs]
  (if (empty? xs) nil
                  (max (maxDifference (into [n] xs))
                       (diffnums n (rest xs)))))

(defn maxDifference [nums]
  (cond
    (= 1 (count nums)) -1
    (= 2 (count nums)) (if (< (first nums) (second nums))
                         (- (second nums) (first nums)))
    :else
    (max (diffnums (first nums) (rest nums))
         (maxDifference (rest nums)))))



(comment

  (def nums [7 1 2 5])

  )