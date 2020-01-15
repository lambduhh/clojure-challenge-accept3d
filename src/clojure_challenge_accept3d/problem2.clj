(ns clojure-challenge-accept3d.problem2)
;Give an array of integers, compute the maximum difference between any item and any
; lower indexed smaller item for all possible pairs. In other words, for the array arr,
; find the maximum value of arr[j] - arr[i] for all i, j where 0 <= i < j < n and arr[i] < arr[j].
; If no item has a smaller item with a lower index, then return -1.
;
;For example, given arr = [1,2,6,4],
; first compare 2 to the elements to its left.
; 1 is smaller, so calculate the difference 2 - 1 = 1.
; 6 is bigger than 2 and 1, so calculate the difference 6 - 2 = 4 and 6 - 1 = 5.
; The last element, 4, is only bigger than 2 and 1, and the difference are 4 - 2 = 2 and 4 - 1 = 3.
; The largest difference is 6 - 1 = 5.
;
;Function Description
;
;Complete the function maxDifference. The function must return an integer that represents the maximum difference in arr.
;
;maxDifference has the following parameter(s): arr[arr[0], arr[1],...arr[n-1]]: an array of integers.
;
;Constraints
;
;1 <= n <= 2*10^5
;-10^6 <= arr[i] <= 10^6 where [0, n-1]


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
  (maxDifference [6 9 9 6 9])
  ;; this is one of the tests that hackerrank says doesn't work :(

  )