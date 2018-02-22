(ns ds.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn swp-max [arr ele]
  (let [ lx (last arr) ]
    (if (> lx ele)
      (conj (pop arr) ele lx)
      (conj arr ele))))

(defn max->end [lst]
  (reduce swp-max [(first lst)] (rest lst)))

(defn bblsrt [lst]
  (let [size (count lst)]
    (loop [iter size result lst]
     (if (= 1 iter)
       result
       (recur (dec iter)
             (concat 
               (max->end (take iter result))
               (into [] 
                     (take-last (- size iter) result)
               )
             )
        )
      )
     )
   )
)
