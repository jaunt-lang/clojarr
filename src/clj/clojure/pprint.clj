;;    Copyright (c) Rich Hickey. All rights reserved.
;;    The use and distribution terms for this software are covered by the
;;    Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;    which can be found in the file epl-v10.html at the root of this distribution.
;;    By using this software in any fashion, you are agreeing to be bound by
;;    the terms of this license.
;;    You must not remove this notice, or any other, from this software.

;; Author: Tom Faulhaber
;; April 3, 2009

(ns clojure.pprint
  "A Pretty Printer for Clojure

  clojure.pprint implements a flexible system for printing structured data
  in a pleasing, easy-to-understand format. Basic use of the pretty printer is
  simple, just call pprint instead of println. More advanced users can use
  the building blocks provided to create custom output formats.

  Out of the box, pprint supports a simple structured format for basic data
  and a specialized format for Clojure source code. More advanced formats,
  including formats that don't look like Clojure data at all like XML and
  JSON, can be rendered by creating custom dispatch functions.

  In addition to the pprint function, this module contains cl-format, a text
  formatting function which is fully compatible with the format function in
  Common Lisp. Because pretty printing directives are directly integrated with
  cl-format, it supports very concise custom dispatch. It also provides
  a more powerful alternative to Clojure's standard format function.

  See documentation for pprint and cl-format for more information or
  complete documentation on the the clojure web site on github."
  {:authors ["Tom Faulhaber <tomfaulhaber@gmail.com>"]
   :added   "0.1.0"}
  (:refer-clojure :exclude (deftype))
  (:require [clojure.walk :refer [walk]]))

(set! *warn-on-reflection* true)

(load "pprint/utilities")
(load "pprint/column_writer")
(load "pprint/pretty_writer")
(load "pprint/pprint_base")
(load "pprint/cl_format")
(load "pprint/dispatch")
(load "pprint/print_table")

nil
