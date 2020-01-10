(ns clojure-challenge-accept3d.problem3)

(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))

(defn nperms [n r]
  (/ (factorial n) (factorial (- n r))))

(comment
  (nperms 10 4)
  )


