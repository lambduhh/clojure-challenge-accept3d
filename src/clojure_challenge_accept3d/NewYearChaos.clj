(ns clojure-challenge-accept3d.NewYearChaos)
;It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!
; There are a number of people queued up, and each person wears a sticker indicating
; their initial position in the queue.
; Initial positions increment by 1 from 1 at the front of the line to `n` at the back.
;
;Any person in the queue can bribe the person directly in front of them to swap positions.
; If two people swap positions, they still wear the same sticker denoting their original places in line.
; One person can bribe at most two others. For example, if  and  bribes , the queue will look like this: [1 2 3 5 4 6 7 8]
;
;Fascinated by this chaotic queue,
; you decide you must know the minimum number of bribes that took place to get the queue into its current state!
;
;Function Description
;
;Complete the function `minimumBribes` in the editor below.
; It must print an integer representing the minimum number of bribes necessary,
; or `Too chaotic` if the line configuration is not possible.
;
;minimumBribes has the following parameter(s):
;
;   q: an array of integers

;Input Format
;The first line contains an integer `t` , the number of test cases.
;
;Each of the next `t` pairs of lines are as follows:
;- The first line contains an integer `t` -the number of people in the queue
;- The second line has `n` space-separated integers describing the final state of the queue.
; Constraints
;   1 <= t <= 10
;   1 <= n <= 10^5
;
;Output Format
;Print an integer denoting the minimum number of bribes needed to get the queue into its final state.
; Print `Too chaotic` if the state is invalid, i.e. it requires a person to have bribed more than 2 people.
;
;Sample Input
;2       test case
;5       n
;2 1 5 3 4
;5
;2 5 1 3 4
;Sample Output
;3
;Too chaotic



(defn init-person [i]
  {:number      i
   :bribes-used 0})

(defn create-state [q]
  {:order       q
   :bribes-left (for [i (range (count q))] 2)
   :steps-taken 0})


(defn switch-positions [v i1 i2]
  "swap two persons where i1 and i2 are indexed positions in vector v"
  (assoc v i2 (v i1) i1 (v i2)))



(defn successors [state]
  "takes a state and returns a sequence of next possible states"
  (for [i (range 1 (count (:bribes-left state)))
        :let [person (get-in state [:order i])
              bribes (get-in state [:bribes-left i])]
        :when (not (zero? bribes)) ]
    {:order       (switch-positions (:order state) i (dec i))
     :bribes-left (switch-positions (update (:bribes-left state) i dec) i (dec i))
     :steps-taken (inc (:steps-taken state))})
  )

(comment
  (def state start-state)
  (def i 2)

  (def t 5)
  (def n (range 1 (+ t 1))) n
  (def sampleinput [2 1 5 3 4])

  (def start-state {:order       [1 2 3 4 5]
                    :bribes-left [2 2 2 2 2]
                    :steps-taken 0})
  (get-in start-state [:order 1])

  (def l (get start-state :order))
  (switch-positions l 0 1)

  (def goal-state {:order       [2 1 5 3 4]
                   :bribes-left [0 0 0 0 0]
                   :steps-taken 0})




  )








