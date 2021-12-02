(ns clojure-advent-of-code-2021.day-1.puzzle-2-test
  (:require [clojure-advent-of-code-2021.day-1.puzzle-2 :as sut]
            [clojure.test :as t]))

(t/deftest correct-depth
 (t/is (sut/depth-calculation '(607 618 618 617 647 716 769 792)) 5))
