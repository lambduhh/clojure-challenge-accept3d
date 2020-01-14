(ns clojure-challenge-accept3d.months-string-filter)
;;months-string-filter is a function that takes a string and returns a string.  The string returned has the following characteristics:
;For each overlapping pair of letters:
;   if the first letter and the second letter are both the first letter in any of the names of the calendar months,
; add both letters to the string;
;   if only the first letter is in the first letter of any of the names of the calendar month, add that to the string;
;   if only the second letter is in the first letter of any of the names of the calendar month, add that to the string
;Overlapping pairs of letter means:
;  for the string abc: (a b) (b c)
;  for the string efgh: (e f) (f g) (g h)
;By "first letter in any name of the calendar month",
; "january" starts with "j", "february" starts with "f",
; and so on.  So if the letters are (j a), both of those are letters that are in the first letters of calendar months so the substring "ja" would appear in the string (like in "jamaica")



(def m-letters (set (vec "jfmamjjasond")))

(defn letter-data [[a b]]
  {:first-letter a
   :first-let-in-m? (m-letters a)
   :second-letter b
   :second-letter-in-m? (m-letters b)})

(defn return-lets-in-m [m]
  (let [first-letter (:first-let-in-m? m)
        second-letter (:second-letter-in-m? m)]
    (cond
      (and first-letter second-letter) [first-letter second-letter]
      first-letter [first-letter]
      second-letter [second-letter]
      :else [] )))

(comment
  (letter-data [a b])                                       ;;-> {:first-letter a, :first-let-in-m? False, ...}
  (return-lets-in-m  {:first-letter \o, :first-let-in-m? \o, :second-letter \g, :second-letter-in-m? nil}) ;-> [\o]
  (return-lets-in-m {:first-letter \g, :first-let-in-m? nil, :second-letter nil, :second-letter-in-m? nil})
    )


(defn month-string-filter [s]
  (->> (partition-all 2 1 s)
       (map letter-data)
       (map return-lets-in-m)
       (map (partial apply str))
       (apply str)
       ))


(comment
  (def s "cog")
  (def ss (partition-all 2 1 s))
  (def sss [{:first-letter \c, :first-let-in-m? nil, :second-letter \o, :second-letter-in-m? \o}
            {:first-letter \o, :first-let-in-m? \o, :second-letter \g, :second-letter-in-m? nil}
            {:first-letter \g, :first-let-in-m? nil, :second-letter nil, :second-letter-in-m? nil}])
  (def ssss (map return-lets-in-m sss))
  (def sssss (map (partial apply str) ssss))
  (apply str sssss)


  (month-string-filter "cognitect")



  )


