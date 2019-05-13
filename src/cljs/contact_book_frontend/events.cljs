(ns contact-book-frontend.events
  (:require
    [re-frame.core :as re-frame]
    [re-graph.core :as re-graph]
    [contact-book-frontend.config :as config]
    [day8.re-frame.tracing :refer-macros [fn-traced]]
    [contact-book-frontend.db :as db]))


(re-frame/reg-event-fx
  :app/initialize
  (fn-traced [_ _]
    {:db       db/default-db
     :dispatch [::re-graph/init {:ws-url   config/ws-url
                                 :http-url config/http-url}]}))

(re-frame/reg-event-db
  ::set-current-page
  (fn-traced [db [_ page]]
    (assoc db :current-page page)))
