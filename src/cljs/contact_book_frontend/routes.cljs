(ns contact-book-frontend.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:require
    [secretary.core :as secretary]
    [accountant.core :as accountant]
    [contact-book-frontend.events :as events]))


(def ^:dynamic *dispatch*
  (fn [event] (prn :dispatch event)))

(defroute home "/" []
  (*dispatch* [::events/set-current-page :home]))

(defroute about "/about" []
  (*dispatch* [::events/set-current-page :about]))


(defn app-routes [dispatch]
  (accountant/configure-navigation!
    {:nav-handler
     (fn [path]
       (binding [*dispatch* dispatch]
         (secretary/dispatch! path)))
     :path-exists?
     (fn [path]
       (secretary/locate-route path))})
  (accountant/dispatch-current!))

(defn navigate! [path]
  (accountant/navigate! path))
