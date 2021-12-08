(ns clojure-advent-of-code-2021.day-3.puzzle-1
  (:require [clojure-advent-of-code-2021.common :as c]))

(def input
  (c/input "resources/day_3/input.txt"))

(defn- foo
  [& binary-chars]
  (reduce (fn [[count-0 count-1] v]
            (if (= v \0)
              [(inc count-0) count-1]
              [count-0 (inc count-1)]))
          [0 0]
          binary-chars))

(defn power-consumption
  [input]
  (let [[gamma-bit epsilon-bit]
        (apply mapv
               (fn [& xs]
                 (clojure.string/join "" xs))
               (map (fn [[count-0 count-1]]
                      (if (> count-0 count-1)
                        [0 1]
                        [1 0]))
                    (apply map foo input)))]
    (* (Integer/parseInt gamma-bit 2) (Integer/parseInt epsilon-bit 2))))
