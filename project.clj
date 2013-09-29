(defproject noencore "0.1.4"
  :description "Clojure and ClojureScript fns not in core."
  :url "http://github.com/r0man/noencore"
  :author "Roman Scherer"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[commons-codec/commons-codec "1.8"]
                 [org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1889"]]
  :profiles {:dev {:dependencies [[com.cemerick/clojurescript.test "0.0.4"]
                                  [com.keminglabs/cljx "0.3.0"]]
                   :plugins [[com.cemerick/austin "0.1.1"]]
                   :repl-options {:nrepl-middleware [cljx.repl-middleware/wrap-cljx]}}}
  :plugins [[com.keminglabs/cljx "0.3.0"]
            [lein-cljsbuild "0.3.3"]]
  :hooks [cljx.hooks leiningen.cljsbuild]
  :cljx {:builds [{:source-paths ["src"]
                   :output-path "target/classes"
                   :rules :clj}
                  {:source-paths ["src"]
                   :output-path "target/classes"
                   :rules :cljs}
                  {:source-paths ["test"]
                   :output-path "target/test-classes"
                   :rules :clj}
                  {:source-paths ["test"]
                   :output-path "target/test-classes"
                   :rules :cljs}]}
  :cljsbuild {:test-commands {"phantom" ["runners/phantomjs.js" "target/testable.js"]}
              :builds [{:source-paths ["target/classes" "target/test-classes"]
                        :compiler {:output-to "target/testable.js"
                                   :libs [""]
                                   :optimizations :advanced
                                   :pretty-print true}}]}
  :test-paths ["target/test-classes"])
