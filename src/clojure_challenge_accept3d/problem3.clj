(ns clojure-challenge-accept3d.problem3)

(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))

(defn nperms [n r]
  (/ (factorial n) (factorial (- n r))))


(comment
  (nperms 10 4)

  (nperms 4 4)
  )




(defn num->nums [num-string]
  (str (Integer/parseInt num-string)))

(comment

  (num->nums "1")
  (num->nums "0110")
  (num->nums "1100"))

(defn counter [s]
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
  (similar? "1100" "0110")


  )



