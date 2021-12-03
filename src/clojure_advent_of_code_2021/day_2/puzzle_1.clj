(ns clojure-advent-of-code-2021.day-2.puzzle-1
  (:require [clojure-advent-of-code-2021.common :as c]
            [clojure.string :as s]))

(def input
  (c/input "resources/day_2/input.txt"))

(defn- command->horizontal-depth
  [row [h d]]
  (let [[cmnd v] (s/split row #" ")
        v* (Integer/parseInt v)]
    (case cmnd
      "forward" [(+ h v*) d]
      "up" [h (+ d (* -1 v*))]
      "down" [h (+ d v*)])))

(defn final-position
  [input]
  (loop [h-d [0 0]
         commands input]
    (if (empty? commands)
      (apply * h-d)
      (recur (command->horizontal-depth (first commands) h-d) (rest commands)))))
