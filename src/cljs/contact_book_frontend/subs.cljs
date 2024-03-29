(ns contact-book-frontend.subs
  (:require
    [re-frame.core :as re-frame]))

(re-frame/reg-sub
  ::name
  (fn [db]
    (:name db)))

(re-frame/reg-sub
  ::current-page
  (fn [db _]
    (:current-page db)))
