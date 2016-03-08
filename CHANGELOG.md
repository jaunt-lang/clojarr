## Change Log

### upcoming
- [#94](https://github.com/jaunt-lang/jaunt/pull/94) Provide a thread binding of *compiler-options* so it may be set! (@arrdem).
- [#93](https://github.com/jaunt-lang/jaunt/pull/93) Display the correct project name in the REPL banner (@arrdem).
- [#92](https://github.com/jaunt-lang/jaunt/pull/92) Fix refer/alias warnings not displaying at the REPL (@arrdem).
- [#89](https://github.com/jaunt-lang/jaunt/pull/89) Add ^:once support to Vars (@arrdem).
  - This changeset enables analysis tooling to distinguish between `Var`s which are bound 'once' and
    those which are simply bound.
  - Add `clojure.lang.Var.isOnce()`, `clojure.lang.Var.setOnce()`, `clojure.lang.Var.setOnce(bool)`.
  - Refactor `clojure.core/defonce` to use `isOnce` and set `^:once` rather than simply checking if
    the `Var` is bound.
  - `clojure.core/defonce` now returns the defined `Var` same as `def`.
  - Add tests of `clojure.core/defonce` with regards to all of the above behavior.
- [#87](https://github.com/jaunt-lang/jaunt/pull/87) Send build notifications to gitter (@arrdem).
- [#86](https://github.com/jaunt-lang/jaunt/pull/86) Fix false changelog linter failures on develop, master, release/* (@arrdem).
- [#84](https://github.com/jaunt-lang/jaunt/pull/84) Whole bag of project changes (@arrdem).
  - Set the project base version to 1.9.0.
  - Emit CircleCI artifact jars on a successful build.
  - Randomly (p 50%) refresh deps on CircleCI because Maven is awful.
  - Add a linter checking that changelog entries have been added.
  - Move the licenses into /etc/licenses.
  - Move the scripts into /etc/bin.
  - Remove some project cruft.
- [#78](https://github.com/jaunt-lang/jaunt/pull/78) Clean up warnings from #62 (@arrdem).
  - Fix warning that `clojure.core/global-higherarchy` looses `^:private` during reloading due to a
    forward declaration lacking the appropriate tag.
  - Fix warning that `clojure.core/process-annotation` looses `^:private` during reloading due to a
    forward declaration lacking the appropriate tag.
- [#76](https://github.com/jaunt-lang/jaunt/pull/76) Rename project to Jaunt (@arrdem).
  - Renames the project from `me.arrdem/clojarr` to `org.jaunt-lang/jaunt`.
- [#71](https://github.com/jaunt-lang/jaunt/pull/71) Bugfix: [CLJ-1579](http://dev.clojure.org/jira/browse/CLJ-1579) (@arrdem).
  - Fixes a bug where `clojure.repl/source-fn` could fail to read the source for a symbol if the
    symbol makes textual use of reader namespaced keywords.
- [#62](https://github.com/jaunt-lang/jaunt/pull/62) Var metadata contracts (@arrdem).
  - Enforce a strict contract between `^:private`, `^:dynamic`, `^:once` as metadata on a `Var` and
    the `isDynamic`/`setDynamic`,`isOnce`/`setOnce`, `isPublic`/`setPublic` methods on the
    `Var`. Ensures that for instance a `Var` can never have `isDynamic → true` without having the
    `^:dynamic` metadata, and that if the `^:dynamic` flag is lost, the `Var` will correctly state
    `isDynamic → false`.
  - Adds a warning when `^:private` is discarded.
  - Adds a warning when `^:dynamic` is discarded.
  - Adds a warning when `^:once` is discarded.
- [#52](https://github.com/jaunt-lang/jaunt/pull/52) Add `clojure.core/*line*` and `clojure.core/*column*` (@arrdem).
  - Exposes the line and column positions (as integers) of the top level form being compiled/evaluated.
- [#50](https://github.com/jaunt-lang/jaunt/pull/50) Add `clojure.core/ns?` (@arrdem).
  - Adds a `ns?` type predicate.
- [#48](https://github.com/jaunt-lang/jaunt/pull/48) Promote `clojure.core/ns-name` from ^:deprecated (@arrdem).
  - Removes the `^:deprecated` flag from `ns-name`
  - Use `clojure.lang.Namespace.name:Symbol` rather than making a new `Symbol` from the ns's name `String`.
- [#44](https://github.com/jaunt-lang/jaunt/pull/44) Bugfix: correct `clojure.core/ns-name` return type (@arrdem).
  - Corrects `ns-name` to return a `Symbol` as before.
  - Broken by #38
- [#38](https://github.com/jaunt-lang/jaunt/pull/38) Named on Namespaces (@arrdem).
  - Implements the `clojure.lang.Named` interface over `clojure.lang.Namespace`.
  - **Breaks** `clojure.lang.Namespace.getName()`. Previously returned `Symbol`, now returns `String`.
- [#37](https://github.com/jaunt-lang/jaunt/pull/37) Named on Vars (@arrdem).
  - Implements the `clojure.lang.Named` interface over `clojure.lang.Var`.
- [#2](https://github.com/jaunt-lang/jaunt/pull/2) Pedantic compiler options (@arrdem).
  - Added `:warn-on-deprecated` (true by default) as a compiler option. When true, the compiler will
    emit warnings when `^:deprecated` Vars or Namespaces are used from outside of a `^:deprecated`
    context (deprecated ns or def).
  - Added `:warn-on-access-violation` (true by defautl) as a compiler option. When true, the
    compiler will emit warnings if `^:private` Vars are accessed from outside the namespace in which
    they are defined.
  - Added `:warn-on-earmuffs` (true by default) as a compiler option. When true, the compiler will
    emit warnings if a Var is named with "earmuffs" (matches `#"^\*.+\*$"`) and is not
    `^:dynamic`. This warning was already present in Clojure, but there was no way to turn it off.
  - Added `:pedantic` (false by default) as a compiler option. When true, all compiler warnings are
    enabled. False by default so that users may more easily selectively mask warnings.
  
### Clojure 1.8
- Jaunt was forked from Clojure just after the 1.8 release, see Clojure's changelog for project
  history.
