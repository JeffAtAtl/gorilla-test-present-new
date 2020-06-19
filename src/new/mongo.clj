(ns new.mongo
  (:use somnium.congomongo))

(mongo! :db "mydb")

(defn lower [s] (.toLowerCase s))

(defn w2cf
  [w]
  (frequencies (sort (map #((comp keyword lower str) %) (seq w)))))

(defn mckeys
  [c]
  (keys (fetch-one c)))

(def words (map :word
                (fetch :words)))

(defn info
  []
  ((juxt databases collections)))

(defn find-matching-words-mongo
  [w]
  (map :word
       (fetch :words3
              :where {:frequency (w2cf w)})))

(w2cf "tar")
