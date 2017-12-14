(defproject noencore "0.3.5-SNAPSHOT"
  :description "Clojure and ClojureScript fns not in core."
  :url "http://github.com/r0man/noencore"
  :author "r0man"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[commons-codec/commons-codec "1.11"]
                 [org.clojure/clojure "1.9.0"]]
  :aliases {"ci" ["do" ["test"] ["doo" "phantom" "test" "once"] ["lint"]]
            "lint" ["do"  ["eastwood"]]}
  :cljsbuild {:builds [{:id "test"
                        :compiler {:main 'no.en.test
                                   :optimizations :advanced
                                   :output-to "target/testable.js"
                                   :pretty-print true}
                        :source-paths ["src" "test"]}]}
  :deploy-repositories [["releases" :clojars]]
  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.2.2"]
                                  [org.clojure/clojurescript "1.9.946"]]
                   :plugins [[jonase/eastwood "0.2.3"]
                             [lein-cljsbuild "1.1.7"]
                             [lein-difftest "2.0.0"]
                             [lein-doo "0.1.8"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}})
