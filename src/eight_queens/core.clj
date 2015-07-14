(ns eight-queens.core
  (:gen-class))

(defn reachablep [q1 q2]
	(let [x1 (first q1)
		  x2 (first q2)
          y1 (last  q1)
          y2 (last  q2)]
		(or
        	(= x1 x2)
        	(= y1 y2)
            (= (Math/abs (- x1 x2)) (Math/abs (- y1 y2))))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  
	(reachablep '(1 1) '(5 2)))	