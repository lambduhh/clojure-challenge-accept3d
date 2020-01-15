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

;refactor using proper workflow and sequential programming
(defn groups [nums]
  {:head (first nums)
   :tail (rest nums)})

(defn pairs [group]
  (let [{:keys [head tail]} group]
    (for [i tail]
      [head i])))

(defn nums->numgroups [nums]
  (if (empty? nums)
    nil
    (apply vector nums (nums->numgroups (rest nums)))))


(comment
  (def group [4 6 2 1])
  ;=> {:head 4, :tail [6 2 1]}
  (pairs {:head 4, :tail [6 2 1]})
  ;=> [[4,6] [4 2] [4 1]]
  (nums->numgroups [4 6 2 1])
  ;=> [[4 6 2 1] [6 2 1] [ 2 1] [1] nil]
  )

(defn findmaxdiff [v]
  (- (first v) (second v))
  ;ret vec
  )

(defn maxDifference [nums]
  (let [nums (reverse nums)
        res
        (->> (nums->numgroups nums)
             (map groups)
             (map pairs)
             (apply concat)
             (map findmaxdiff)
             (apply max))]
    (if (< res 1)
      -1
      res)))

(comment
  (def nums [1 2 6 4])
  (maxDifference [])
  (def nums2 [{:head 1, :tail [2 6 4]}
              {:head 2, :tail [6 4]}
              {:head 6, :tail [4]}
              {:head 4, :tail ()}])
  (def nums3 [[1 2] [1 6] [1 4] [2 6] [2 4] [6 4]])
  (findmaxdiff [1 2])
  ;=> 1
  )


(comment

  (maxDifference [1 2 3 4 5])
  (maxDifference [7 5 3 1])
  (maxDifference [7 1 2 5])
  (maxDifference [6 9 9 6 9])
  ;; this is one of the tests that hackerrank says doesn't work :(

  )