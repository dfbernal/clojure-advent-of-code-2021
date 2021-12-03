(ns clojure-advent-of-code-2021.day-2.puzzle-2
  (:require [clojure-advent-of-code-2021.common :as c]
            [clojure.string :as s]))

(def input
  (c/input "resources/day_2/input.txt"))

(defn- command->horizontal-depth
  [row [h d a]]
  (let [[cmnd v] (s/split row #" ")
        v* (Integer/parseInt v)]
    (case cmnd
      "forward" [(+ h v*) (+ d (* a v*)) a]
      "up" [h d (+ a (* -1 v*))]
      "down" [h d (+ a v*)])))

(defn final-position
  [input]
  (loop [h-d-a [0 0 0]
         commands input]
    (if (empty? commands)
      (apply * (take 2 h-d-a))
      (recur (command->horizontal-depth (first commands) h-d-a) (rest commands)))))
