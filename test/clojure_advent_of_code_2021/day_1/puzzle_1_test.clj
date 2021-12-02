(ns clojure-advent-of-code-2021.day-1.puzzle-1-test
  (:require [clojure-advent-of-code-2021.day-1.puzzle-1 :as sut]
            [clojure.test :as t]))

(t/deftest correct-depth
 (t/is (sut/depth-calculation '(199 200 208 210 200 207 240 269 260 263)) 7))
