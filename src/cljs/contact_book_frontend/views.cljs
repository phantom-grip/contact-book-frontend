(ns contact-book-frontend.views
  (:require
    [re-frame.core :as re-frame]
    [contact-book-frontend.subs :as subs]
    [contact-book-frontend.routes :as routes]))



;; home

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 (str "Hello from " @name ". This is the Home Page.")]

     [:div
      [:a {:href (routes/about)}
       "go to About Page"]]]))



;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:href (routes/home)}
     "go to Home Page"]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home [home-panel]
    :about [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/current-page])]
    [show-panel @active-panel]))
