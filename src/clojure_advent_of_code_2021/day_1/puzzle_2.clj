(ns clojure-advent-of-code-2021.day-1.puzzle-2
  (:require [clojure.java.io :as io]))

(def input
  (read-string
   (slurp
    (io/resource 
     "day_1/input.edn"))))

(defn depth-calculation
  [depths]
  (loop [depth-coll (rest depths)
         previous (take 3 depths) 
         num-increase 0]
    (let [curr (take 3 depth-coll)]
      (if (<= (count curr) 2)
        num-increase
        (recur (rest depth-coll)
               curr
               (if (< (reduce + previous) (reduce + curr)) (inc num-increase) num-increase))))))
