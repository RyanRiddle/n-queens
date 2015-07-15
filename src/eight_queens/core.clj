(ns eight-queens.core
	(require [clojure.math.combinatorics :as combo])
  (:gen-class))

(defn reachable-p [q1 q2]
	(let [x1 (first q1)
		  x2 (first q2)
          y1 (last  q1)
          y2 (last  q2)]
		(or
        	(= x1 x2)
        	(= y1 y2)
            (= (Math/abs (- x1 x2)) (Math/abs (- y1 y2))))))

(defn board-fails-p [positions]
	(if (< (count positions) 2)
		false
		(let [q1 (first positions)
			  others (rest positions)]
			(or
				(reduce 
					(fn [result q2]
						(or result (reachable-p q1 q2))) 
						false
						others)
				(board-fails-p others)))))

(defn generate-boards []
	(let [perms (combo/permutations (range 8))]
		(map (fn [x]
				(reverse (zipmap x (range 8))))
				perms)))

(defn solve [boards]
	(remove #'board-fails-p boards))

(defn print-board [board]
	(dotimes [row 8]
		(println
			(clojure.string/join
				"|"
				(map (fn [x] (if (= (first x) row) "X" "_")) board))))

	(print "\n\n\n"))

(defn -main
  "8 queens problem"
  [& args]

	(let [solutions (solve (generate-boards))]
		(print-board (first solutions))))
