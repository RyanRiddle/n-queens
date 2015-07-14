(ns eight-queens.core-test
  (:require [clojure.test :refer :all]
            [eight-queens.core :refer :all]))

(deftest test-reachablep
  (testing "Looks like reachablep cannot tell if one queen reaches another"
    (reachablep '(0 0) '(0 1))))
