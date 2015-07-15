(ns eight-queens.core
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


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  
	(reachable-p '(1 1) '(5 2)))	
