(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))


(defn less-than [n]
  (fn [i] (< i n)))


(defn equal-to [n]
  (fn [i] (== i n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))


(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)(pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)(pred2 x))))


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
 (or
  (every? whitespace? string)
  (= blank? string)
  (= nil? string)))

(defn has-award? [book award]
   (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [palkinnot? (fn [i] (has-award? book i))]
    (every? true? (map palkinnot? awards) )))






(defn my-some [pred a-seq]
  (first (map  pred (filter pred a-seq)) ))

(defn my-every? [pred a-seq]
  (nil? (my-some (complement pred) a-seq)))


(defn prime? [n]
(let [jakaja (fn [y] (== 0 (mod n y)))]
(not (some jakaja (range 2 n)))))
;^^

