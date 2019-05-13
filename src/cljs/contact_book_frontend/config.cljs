(ns contact-book-frontend.config)

(def debug?
  ^boolean goog.DEBUG)

(goog-define http-url "/graphql")

(goog-define ws-url "/graphql-ws")
