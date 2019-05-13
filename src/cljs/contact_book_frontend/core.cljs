(ns contact-book-frontend.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [contact-book-frontend.events :as events]
   [contact-book-frontend.routes :as routes]
   [contact-book-frontend.views :as views]
   [contact-book-frontend.config :as config]))



(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (routes/app-routes re-frame/dispatch)
  (dev-setup)
  (mount-root))
