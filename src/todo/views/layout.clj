(ns todo.views.layout
  (:require [hiccup.page :refer [html5 include-css include-js]]))

(defn container [& body]
  (html5
    [:head
     [:title "CLJS Todo"]
     (include-css "/css/screen.css")
     (include-css "/css/bootstrap.css")
     (include-js "/js/main.js")]
    [:body body]))

(defn todo-template []
  (container
    [:div.container
      [:div.row
        [:div.col-md-12
          [:div.todo ]
          [:input#text.input {:type "text" :placeholder "Write your todo"}]
          [:button#add.btn.btn-primary "Add"]]]]))


