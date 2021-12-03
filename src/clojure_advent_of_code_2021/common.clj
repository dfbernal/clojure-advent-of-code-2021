(ns clojure-advent-of-code-2021.common)

(defn input
  [path]
  (-> (slurp path)
      (clojure.string/split-lines)))
