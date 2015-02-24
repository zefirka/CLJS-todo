(defproject cljstodo "0.0.1"
  :description "Simple TODO with ClojureScript"
  :url "https://github.com/zefirka/cljs-todo"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [enfocus "2.1.1"]
                 [org.clojure/clojurescript "0.0-2505"]
                 [org.clojars.franks42/cljs-uuid-utils "0.1.3"]]
  :plugins [[lein-ring "0.8.12"]
            [lein-cljsbuild "1.0.4-SNAPSHOT"]]
  :cljsbuild {:builds [
                       {:source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :repl-options {:nrepl-middleware [lighttable.nrepl.handler/lighttable-ops]}
  :ring {:handler todo.handler/app
         :init todo.handler/init
         :destroy todo.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? true, :stacktraces? false, :auto-reload? true}}
   :dev
   {:dependencies [[ring-mock "0.1.5"]
                   [ring/ring-devel "1.3.1"]
                   [lein-light-nrepl "0.1.0"]]}})
