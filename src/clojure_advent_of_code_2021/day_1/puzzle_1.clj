(ns clojure-advent-of-code-2021.day-1.puzzle-1
  (:require [clojure.java.io :as io]))

(def input
  (read-string
   (slurp
    (io/resource 
     "day_1/input.edn"))))

(defn depth-calculation
  [depths]
  (loop [depth-coll (rest depths)
         previous (first depths)
         num-increase 0] 
    (let [curr (first depth-coll)]
      (if (empty? depth-coll)
        num-increase
        (recur (rest depth-coll)
               curr
               (if (< previous curr) (inc num-increase) num-increase))))))
