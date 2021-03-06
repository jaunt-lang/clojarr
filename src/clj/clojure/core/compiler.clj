;;    Copyright (c) Reid McKenzie. All rights reserved.
;;    The use and distribution terms for this software are covered by the
;;    Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;    which can be found in the file epl-v10.html at the root of this distribution.
;;    By using this software in any fashion, you are agreeing to be bound by
;;    the terms of this license.
;;    You must not remove this notice, or any other, from this software.

(ns clojure.core.compiler
  "EXPERIMENTAL and definitely unstable.

  Compiler and runtime introspection utilities."
  {:authors ["Reid 'arrdem' McKenzie <me@arrdem.com>"]
   :added   "0.2.0"}
  (:import [clojure.lang PersistentQueue]))

(defn uses
  "EXPERIMENTAL

  Returns the use set of a Fn, or of a Var bound to a Fn. The use set of other values is defined to
  the empty set."
  [o]
  (cond (fn? o)  (:uses (meta o) #{})
        (var? o) (recur (deref o))
        :else    #{}))

(defn reaches
  "EXPERIMENTAL

  Returns the reach set of a Fn, or of a Var bound to a Fn. The reach set of other values is defined
  to be the empty set."
  [o]
  (loop [acc                    #{}
         [o & worklist' :as wl] (into PersistentQueue/EMPTY (uses o))]
    (if-not (empty? wl)
      (let [acc' (conj acc o)]
        (recur (into acc' (uses o))
               (into worklist' (remove acc' (uses o)))))
      acc)))
