(ns clojure-challenge-accept3d.problem3)

(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))

(defn nperms [n r]
  (/ (factorial n) (factorial (- n r))))

(defn ncross
  "a function that finds the cartesian cross product"
  [[x & xs]]
  (if (empty? xs)
    (for [ax x] [ax])
    (for [ax x xi (ncross xs)] (into [ax] xi))))

(comment
  (ncross [[1 1] [2 1] [3 3]])
  (ncross [[1 1 0 0] [1 1 0 0] [1 1 0 0] [1 1 0 0]])
  (ncross [[1 2 3 4] [1 2 3 4] [1 2 3 4] [1 2 3 4]]))


(defn num->nums [num-string]
  (str (Integer/parseInt num-string)))

(comment
  (num->nums "1")
  (num->nums "0110")
  (num->nums "1100"))

(defn counter [s]
  "collections.Counter in python"
  (reduce (fn [res x] (update res x (fnil inc 0))) {} s))

(comment
  (counter "110")
  (counter "1110"))

(defn similar? [a b]
  (and (= a (num->nums a))
       (= b (num->nums b))
       (= (counter (num->nums a))
          (counter (num->nums b)))))

(comment
  (similar? "110" "1110")
  (similar? "0110" "110")
  (similar? "1100" "0110"))


(defn cross-strings [n]
  (let [n (num->nums n)]
    (map (partial apply str) (ncross (vec (repeat (count n) (vec n)))))))

(comment
  (vec (num->nums "0110"))
  (cross-strings "0110"))

(defn similar-strings [a]
  (set (filter (partial similar? a) (cross-strings a))))

(comment
  (similar-strings "1100")
  )

(defn similarities [a b]
  (if (similar? a b)
    (count (similar-strings a))
    (count (similar-strings b))))

(comment
  (similarities "1234" "2341")
  (similarities "1100" "1001")

  (counter "1100")
  (let [a "1100"]
    (nperms (count (set ))))

  )

