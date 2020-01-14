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



(def l-months (set (vec "jfmamjjasond")))

(defn letter-data [[a b]]
  {:first-letter             a
   :first-letter-in-months?  (get l-months a)
   :second-letter            b
   :second-letter-in-months? (get l-months b)})

(defn data->letter [data]
  (let [{:keys [first-letter first-letter-in-months? second-letter second-letter-in-months?]} data]
    (cond
      (and first-letter-in-months? second-letter-in-months?) [first-letter second-letter]
      first-letter-in-months? [first-letter]
      second-letter-in-months? [second-letter]
      :else [])))

(comment
  (data->letter {:first-letter \o, :first-letter-in-months? \o, :second-letter \g, :second-letter-in-months? \g})
  ;;=>[\o \g]
  (data->letter {:first-letter \o, :first-letter-in-months? \o, :second-letter \g, :second-letter-in-months? nil})
  ;;=>[\o]
  (data->letter {:first-letter \o, :first-letter-in-months? nil, :second-letter \g, :second-letter-in-months? \g})
  ;;=>[\o]
  (data->letter {:first-letter \o, :first-letter-in-months? nil, :second-letter \g, :second-letter-in-months? nil})
  ;;=> []
  )

(defn vec->str [v]
  (apply str v))

(defn months-string-filter [s]
  (->> (partition-all 2 1 s)
       (map letter-data)
       (map data->letter)
       (mapv vec->str)
       (vec->str)))


(comment
  (def s1 [[\c \o] [\o \g] [\g]])
  (def s2 (map letter-data s1))
  (map data->letter s2)
  ;;-> [[\o][\o]]
  (def s3 [[\o] [\o] []])
  (def s4 (mapv vec->str s3))
  ;=> ("o" "o")
  (vec->str s4)
  (months-string-filter "cog")
  ;-> "oo"
  )
