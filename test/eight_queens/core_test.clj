(ns eight-queens.core-test
  (:require [clojure.test :refer :all]
            [eight-queens.core :refer :all]))

(deftest test-reachable-p-returns-true
  (testing "Looks like reachable-p cannot tell if one queen reaches another"
    (is (reachable-p '(0 0) '(0 1)) true)))

(deftest test-reachable-p-returns-false
	(testing "reachable-p says two queens that cannot reach each other can"
		(is (reachable-p '(0 0) (1 7)) false)))

(deftest test-board-fails-p-returns-true
	(testing "board-fails-p returned false when it should have returned true"
		(is (board-fails-p '((0 0) (1 7) (2 1) (1 3))) true)))

(deftest test-board-fails-p-returns-false
	(testing "board-fails-p returned true when it should have returned false"
		(is (board-fails-p '((0 0) (1 7) (2 5))) false)))
