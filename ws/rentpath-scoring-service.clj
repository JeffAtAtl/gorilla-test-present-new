;; gorilla-repl.fileformat = 1

;; **
;;; # Gorilla REPL
;;; 
;;; Welcome to gorilla :-)
;;; 
;;; Shift + enter evaluates code. Hit alt+g twice in quick succession or click the menu icon (upper-right corner) for more commands ...
;;; 
;;; It's a good habit to run each worksheet in its own namespace: feel free to use the declaration we've provided below if you'd like.
;; **

;; @@
(ns rentpath-scoring-service
  (:require [tentacles.events :as gitapi])
  (:require [clojure.pprint :as pp])
  (:use [clojure.repl])
  (:use [gorilla-repl table latex html]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(->> (gitapi/user-events "jeffatatl")
     count)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>6</span>","value":"6"}
;; <=

;; @@
(->> (gitapi/user-events "jeffatatl")
     first
     keys)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(:id :type :actor :repo :payload :public :created_at :org)</span>","value":"(:id :type :actor :repo :payload :public :created_at :org)"}
;; <=

;; @@
(->> (gitapi/user-events "jeffatatl")
     pp/pprint)
;; @@
;; ->
;;; ({:id &quot;12623211499&quot;,
;;;   :type &quot;IssuesEvent&quot;,
;;;   :actor
;;;   {:id 131416,
;;;    :login &quot;nathanmarz&quot;,
;;;    :display_login &quot;nathanmarz&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/users/nathanmarz&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/131416?&quot;},
;;;   :repo
;;;   {:id 31374926,
;;;    :name &quot;redplanetlabs/specter&quot;,
;;;    :url &quot;https://api.github.com/repos/redplanetlabs/specter&quot;},
;;;   :payload
;;;   {:action &quot;closed&quot;,
;;;    :issue
;;;    {:html_url &quot;https://github.com/redplanetlabs/specter/issues/289&quot;,
;;;     :labels [],
;;;     :assignees [],
;;;     :closed_at &quot;2020-06-13T21:29:35Z&quot;,
;;;     :active_lock_reason nil,
;;;     :author_association &quot;NONE&quot;,
;;;     :number 289,
;;;     :milestone nil,
;;;     :repository_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter&quot;,
;;;     :comments 1,
;;;     :node_id &quot;MDU6SXNzdWU2MzgxMzg0Njk=&quot;,
;;;     :state &quot;closed&quot;,
;;;     :title &quot;Rename ALL to EACH&quot;,
;;;     :labels_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289/labels{/name}&quot;,
;;;     :updated_at &quot;2020-06-13T21:29:35Z&quot;,
;;;     :comments_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289/comments&quot;,
;;;     :locked false,
;;;     :id 638138469,
;;;     :events_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289/events&quot;,
;;;     :url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289&quot;,
;;;     :body
;;;     &quot;I recently finally understood the approach of specter, after having first heard of it a few years ago. It&#x27;s actually quite simple, once you&#x27;re over the first bump.\r\n\r\nOne part that tripped me up in the beginning was ALL. I understand it now, but before I did, the name ALL didn&#x27;t help me. specter always looks at all elements of a sequence, why do I need to specify that?\r\n\r\nNow it is clear that ALL is way of saying \&quot;go one level deeper into the structure (without any further filtering or anything)\&quot;, or \&quot;the structure is good up to here, now look at each of its elements\&quot;.\r\n\r\nI believe, EACH instead of ALL is more intuitive to read.\r\n\r\nSo I&#x27;m proposing to add EACH as an alias for ALL and use EACH instead of ALL in all the documentation.&quot;,
;;;     :user
;;;     {:html_url &quot;https://github.com/mbertheau&quot;,
;;;      :gravatar_id &quot;&quot;,
;;;      :followers_url &quot;https://api.github.com/users/mbertheau/followers&quot;,
;;;      :subscriptions_url
;;;      &quot;https://api.github.com/users/mbertheau/subscriptions&quot;,
;;;      :site_admin false,
;;;      :following_url
;;;      &quot;https://api.github.com/users/mbertheau/following{/other_user}&quot;,
;;;      :node_id &quot;MDQ6VXNlcjEzMzU3NQ==&quot;,
;;;      :type &quot;User&quot;,
;;;      :received_events_url
;;;      &quot;https://api.github.com/users/mbertheau/received_events&quot;,
;;;      :login &quot;mbertheau&quot;,
;;;      :organizations_url &quot;https://api.github.com/users/mbertheau/orgs&quot;,
;;;      :id 133575,
;;;      :events_url
;;;      &quot;https://api.github.com/users/mbertheau/events{/privacy}&quot;,
;;;      :url &quot;https://api.github.com/users/mbertheau&quot;,
;;;      :repos_url &quot;https://api.github.com/users/mbertheau/repos&quot;,
;;;      :starred_url
;;;      &quot;https://api.github.com/users/mbertheau/starred{/owner}{/repo}&quot;,
;;;      :gists_url
;;;      &quot;https://api.github.com/users/mbertheau/gists{/gist_id}&quot;,
;;;      :avatar_url
;;;      &quot;https://avatars0.githubusercontent.com/u/133575?v=4&quot;},
;;;     :assignee nil,
;;;     :created_at &quot;2020-06-13T10:32:53Z&quot;}},
;;;   :public true,
;;;   :created_at &quot;2020-06-13T21:29:36Z&quot;,
;;;   :org
;;;   {:id 2371803,
;;;    :login &quot;redplanetlabs&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/orgs/redplanetlabs&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/2371803?&quot;}}
;;;  {:id &quot;12623211483&quot;,
;;;   :type &quot;IssueCommentEvent&quot;,
;;;   :actor
;;;   {:id 131416,
;;;    :login &quot;nathanmarz&quot;,
;;;    :display_login &quot;nathanmarz&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/users/nathanmarz&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/131416?&quot;},
;;;   :repo
;;;   {:id 31374926,
;;;    :name &quot;redplanetlabs/specter&quot;,
;;;    :url &quot;https://api.github.com/repos/redplanetlabs/specter&quot;},
;;;   :payload
;;;   {:action &quot;created&quot;,
;;;    :issue
;;;    {:html_url &quot;https://github.com/redplanetlabs/specter/issues/289&quot;,
;;;     :labels [],
;;;     :assignees [],
;;;     :closed_at &quot;2020-06-13T21:29:35Z&quot;,
;;;     :active_lock_reason nil,
;;;     :author_association &quot;NONE&quot;,
;;;     :number 289,
;;;     :milestone nil,
;;;     :repository_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter&quot;,
;;;     :comments 1,
;;;     :node_id &quot;MDU6SXNzdWU2MzgxMzg0Njk=&quot;,
;;;     :state &quot;closed&quot;,
;;;     :title &quot;Rename ALL to EACH&quot;,
;;;     :labels_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289/labels{/name}&quot;,
;;;     :updated_at &quot;2020-06-13T21:29:35Z&quot;,
;;;     :comments_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289/comments&quot;,
;;;     :locked false,
;;;     :id 638138469,
;;;     :events_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289/events&quot;,
;;;     :url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289&quot;,
;;;     :body
;;;     &quot;I recently finally understood the approach of specter, after having first heard of it a few years ago. It&#x27;s actually quite simple, once you&#x27;re over the first bump.\r\n\r\nOne part that tripped me up in the beginning was ALL. I understand it now, but before I did, the name ALL didn&#x27;t help me. specter always looks at all elements of a sequence, why do I need to specify that?\r\n\r\nNow it is clear that ALL is way of saying \&quot;go one level deeper into the structure (without any further filtering or anything)\&quot;, or \&quot;the structure is good up to here, now look at each of its elements\&quot;.\r\n\r\nI believe, EACH instead of ALL is more intuitive to read.\r\n\r\nSo I&#x27;m proposing to add EACH as an alias for ALL and use EACH instead of ALL in all the documentation.&quot;,
;;;     :user
;;;     {:html_url &quot;https://github.com/mbertheau&quot;,
;;;      :gravatar_id &quot;&quot;,
;;;      :followers_url &quot;https://api.github.com/users/mbertheau/followers&quot;,
;;;      :subscriptions_url
;;;      &quot;https://api.github.com/users/mbertheau/subscriptions&quot;,
;;;      :site_admin false,
;;;      :following_url
;;;      &quot;https://api.github.com/users/mbertheau/following{/other_user}&quot;,
;;;      :node_id &quot;MDQ6VXNlcjEzMzU3NQ==&quot;,
;;;      :type &quot;User&quot;,
;;;      :received_events_url
;;;      &quot;https://api.github.com/users/mbertheau/received_events&quot;,
;;;      :login &quot;mbertheau&quot;,
;;;      :organizations_url &quot;https://api.github.com/users/mbertheau/orgs&quot;,
;;;      :id 133575,
;;;      :events_url
;;;      &quot;https://api.github.com/users/mbertheau/events{/privacy}&quot;,
;;;      :url &quot;https://api.github.com/users/mbertheau&quot;,
;;;      :repos_url &quot;https://api.github.com/users/mbertheau/repos&quot;,
;;;      :starred_url
;;;      &quot;https://api.github.com/users/mbertheau/starred{/owner}{/repo}&quot;,
;;;      :gists_url
;;;      &quot;https://api.github.com/users/mbertheau/gists{/gist_id}&quot;,
;;;      :avatar_url
;;;      &quot;https://avatars0.githubusercontent.com/u/133575?v=4&quot;},
;;;     :assignee nil,
;;;     :created_at &quot;2020-06-13T10:32:53Z&quot;},
;;;    :comment
;;;    {:html_url
;;;     &quot;https://github.com/redplanetlabs/specter/issues/289#issuecomment-643680839&quot;,
;;;     :author_association &quot;COLLABORATOR&quot;,
;;;     :node_id &quot;MDEyOklzc3VlQ29tbWVudDY0MzY4MDgzOQ==&quot;,
;;;     :issue_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289&quot;,
;;;     :updated_at &quot;2020-06-13T21:29:35Z&quot;,
;;;     :id 643680839,
;;;     :url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/comments/643680839&quot;,
;;;     :body
;;;     &quot;I think this is up for debate, but with the main goal of the project now being stability a rename/alias  is pretty much out of the question.&quot;,
;;;     :user
;;;     {:html_url &quot;https://github.com/nathanmarz&quot;,
;;;      :gravatar_id &quot;&quot;,
;;;      :followers_url
;;;      &quot;https://api.github.com/users/nathanmarz/followers&quot;,
;;;      :subscriptions_url
;;;      &quot;https://api.github.com/users/nathanmarz/subscriptions&quot;,
;;;      :site_admin false,
;;;      :following_url
;;;      &quot;https://api.github.com/users/nathanmarz/following{/other_user}&quot;,
;;;      :node_id &quot;MDQ6VXNlcjEzMTQxNg==&quot;,
;;;      :type &quot;User&quot;,
;;;      :received_events_url
;;;      &quot;https://api.github.com/users/nathanmarz/received_events&quot;,
;;;      :login &quot;nathanmarz&quot;,
;;;      :organizations_url &quot;https://api.github.com/users/nathanmarz/orgs&quot;,
;;;      :id 131416,
;;;      :events_url
;;;      &quot;https://api.github.com/users/nathanmarz/events{/privacy}&quot;,
;;;      :url &quot;https://api.github.com/users/nathanmarz&quot;,
;;;      :repos_url &quot;https://api.github.com/users/nathanmarz/repos&quot;,
;;;      :starred_url
;;;      &quot;https://api.github.com/users/nathanmarz/starred{/owner}{/repo}&quot;,
;;;      :gists_url
;;;      &quot;https://api.github.com/users/nathanmarz/gists{/gist_id}&quot;,
;;;      :avatar_url
;;;      &quot;https://avatars0.githubusercontent.com/u/131416?v=4&quot;},
;;;     :created_at &quot;2020-06-13T21:29:35Z&quot;}},
;;;   :public true,
;;;   :created_at &quot;2020-06-13T21:29:35Z&quot;,
;;;   :org
;;;   {:id 2371803,
;;;    :login &quot;redplanetlabs&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/orgs/redplanetlabs&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/2371803?&quot;}}
;;;  {:id &quot;12621095098&quot;,
;;;   :type &quot;IssuesEvent&quot;,
;;;   :actor
;;;   {:id 133575,
;;;    :login &quot;mbertheau&quot;,
;;;    :display_login &quot;mbertheau&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/users/mbertheau&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/133575?&quot;},
;;;   :repo
;;;   {:id 31374926,
;;;    :name &quot;redplanetlabs/specter&quot;,
;;;    :url &quot;https://api.github.com/repos/redplanetlabs/specter&quot;},
;;;   :payload
;;;   {:action &quot;opened&quot;,
;;;    :issue
;;;    {:html_url &quot;https://github.com/redplanetlabs/specter/issues/289&quot;,
;;;     :labels [],
;;;     :assignees [],
;;;     :closed_at nil,
;;;     :active_lock_reason nil,
;;;     :author_association &quot;NONE&quot;,
;;;     :number 289,
;;;     :milestone nil,
;;;     :repository_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter&quot;,
;;;     :comments 0,
;;;     :node_id &quot;MDU6SXNzdWU2MzgxMzg0Njk=&quot;,
;;;     :state &quot;open&quot;,
;;;     :title &quot;Rename ALL to EACH&quot;,
;;;     :labels_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289/labels{/name}&quot;,
;;;     :updated_at &quot;2020-06-13T10:32:53Z&quot;,
;;;     :comments_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289/comments&quot;,
;;;     :locked false,
;;;     :id 638138469,
;;;     :events_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289/events&quot;,
;;;     :url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/289&quot;,
;;;     :body
;;;     &quot;I recently finally understood the approach of specter, after having first heard of it a few years ago. It&#x27;s actually quite simple, once you&#x27;re over the first bump.\r\n\r\nOne part that tripped me up in the beginning was ALL. I understand it now, but before I did, the name ALL didn&#x27;t help me. specter always looks at all elements of a sequence, why do I need to specify that?\r\n\r\nNow it is clear that ALL is way of saying \&quot;go one level deeper into the structure (without any further filtering or anything)\&quot;, or \&quot;the structure is good up to here, now look at each of its elements\&quot;.\r\n\r\nI believe, `EACH` instead of `ALL` is more intuitive to read.\r\n\r\nSo I&#x27;m proposing to add EACH as an alias for ALL and use EACH instead of ALL in all the documentation.&quot;,
;;;     :user
;;;     {:html_url &quot;https://github.com/mbertheau&quot;,
;;;      :gravatar_id &quot;&quot;,
;;;      :followers_url &quot;https://api.github.com/users/mbertheau/followers&quot;,
;;;      :subscriptions_url
;;;      &quot;https://api.github.com/users/mbertheau/subscriptions&quot;,
;;;      :site_admin false,
;;;      :following_url
;;;      &quot;https://api.github.com/users/mbertheau/following{/other_user}&quot;,
;;;      :node_id &quot;MDQ6VXNlcjEzMzU3NQ==&quot;,
;;;      :type &quot;User&quot;,
;;;      :received_events_url
;;;      &quot;https://api.github.com/users/mbertheau/received_events&quot;,
;;;      :login &quot;mbertheau&quot;,
;;;      :organizations_url &quot;https://api.github.com/users/mbertheau/orgs&quot;,
;;;      :id 133575,
;;;      :events_url
;;;      &quot;https://api.github.com/users/mbertheau/events{/privacy}&quot;,
;;;      :url &quot;https://api.github.com/users/mbertheau&quot;,
;;;      :repos_url &quot;https://api.github.com/users/mbertheau/repos&quot;,
;;;      :starred_url
;;;      &quot;https://api.github.com/users/mbertheau/starred{/owner}{/repo}&quot;,
;;;      :gists_url
;;;      &quot;https://api.github.com/users/mbertheau/gists{/gist_id}&quot;,
;;;      :avatar_url
;;;      &quot;https://avatars0.githubusercontent.com/u/133575?v=4&quot;},
;;;     :assignee nil,
;;;     :created_at &quot;2020-06-13T10:32:53Z&quot;}},
;;;   :public true,
;;;   :created_at &quot;2020-06-13T10:32:54Z&quot;,
;;;   :org
;;;   {:id 2371803,
;;;    :login &quot;redplanetlabs&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/orgs/redplanetlabs&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/2371803?&quot;}}
;;;  {:id &quot;11966464563&quot;,
;;;   :type &quot;IssuesEvent&quot;,
;;;   :actor
;;;   {:id 131416,
;;;    :login &quot;nathanmarz&quot;,
;;;    :display_login &quot;nathanmarz&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/users/nathanmarz&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/131416?&quot;},
;;;   :repo
;;;   {:id 31374926,
;;;    :name &quot;redplanetlabs/specter&quot;,
;;;    :url &quot;https://api.github.com/repos/redplanetlabs/specter&quot;},
;;;   :payload
;;;   {:action &quot;closed&quot;,
;;;    :issue
;;;    {:html_url &quot;https://github.com/redplanetlabs/specter/issues/288&quot;,
;;;     :labels [],
;;;     :assignees [],
;;;     :closed_at &quot;2020-04-06T03:34:30Z&quot;,
;;;     :author_association &quot;NONE&quot;,
;;;     :number 288,
;;;     :milestone nil,
;;;     :repository_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter&quot;,
;;;     :comments 1,
;;;     :node_id &quot;MDU6SXNzdWU1OTQ3NDM3MjM=&quot;,
;;;     :state &quot;closed&quot;,
;;;     :title &quot;Transform all after FIRST&quot;,
;;;     :labels_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288/labels{/name}&quot;,
;;;     :updated_at &quot;2020-04-06T03:34:30Z&quot;,
;;;     :comments_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288/comments&quot;,
;;;     :locked false,
;;;     :id 594743723,
;;;     :events_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288/events&quot;,
;;;     :url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288&quot;,
;;;     :body
;;;     &quot;I&#x27;m working with a CSV file and I want to transform values and ignore the header.\r\n\r\nI can use `(let [header &amp; rows] csv)` but I&#x27;d like to be able to do this using specter without splitting out the headers separately.\r\n\r\nIs there an idiomatic way of doing this?&quot;,
;;;     :user
;;;     {:html_url &quot;https://github.com/stuartrexking&quot;,
;;;      :gravatar_id &quot;&quot;,
;;;      :followers_url
;;;      &quot;https://api.github.com/users/stuartrexking/followers&quot;,
;;;      :subscriptions_url
;;;      &quot;https://api.github.com/users/stuartrexking/subscriptions&quot;,
;;;      :site_admin false,
;;;      :following_url
;;;      &quot;https://api.github.com/users/stuartrexking/following{/other_user}&quot;,
;;;      :node_id &quot;MDQ6VXNlcjY1MjE0&quot;,
;;;      :type &quot;User&quot;,
;;;      :received_events_url
;;;      &quot;https://api.github.com/users/stuartrexking/received_events&quot;,
;;;      :login &quot;stuartrexking&quot;,
;;;      :organizations_url
;;;      &quot;https://api.github.com/users/stuartrexking/orgs&quot;,
;;;      :id 65214,
;;;      :events_url
;;;      &quot;https://api.github.com/users/stuartrexking/events{/privacy}&quot;,
;;;      :url &quot;https://api.github.com/users/stuartrexking&quot;,
;;;      :repos_url &quot;https://api.github.com/users/stuartrexking/repos&quot;,
;;;      :starred_url
;;;      &quot;https://api.github.com/users/stuartrexking/starred{/owner}{/repo}&quot;,
;;;      :gists_url
;;;      &quot;https://api.github.com/users/stuartrexking/gists{/gist_id}&quot;,
;;;      :avatar_url &quot;https://avatars0.githubusercontent.com/u/65214?v=4&quot;},
;;;     :assignee nil,
;;;     :created_at &quot;2020-04-06T01:19:22Z&quot;}},
;;;   :public true,
;;;   :created_at &quot;2020-04-06T03:34:30Z&quot;,
;;;   :org
;;;   {:id 2371803,
;;;    :login &quot;redplanetlabs&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/orgs/redplanetlabs&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/2371803?&quot;}}
;;;  {:id &quot;11966464542&quot;,
;;;   :type &quot;IssueCommentEvent&quot;,
;;;   :actor
;;;   {:id 131416,
;;;    :login &quot;nathanmarz&quot;,
;;;    :display_login &quot;nathanmarz&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/users/nathanmarz&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/131416?&quot;},
;;;   :repo
;;;   {:id 31374926,
;;;    :name &quot;redplanetlabs/specter&quot;,
;;;    :url &quot;https://api.github.com/repos/redplanetlabs/specter&quot;},
;;;   :payload
;;;   {:action &quot;created&quot;,
;;;    :issue
;;;    {:html_url &quot;https://github.com/redplanetlabs/specter/issues/288&quot;,
;;;     :labels [],
;;;     :assignees [],
;;;     :closed_at &quot;2020-04-06T03:34:30Z&quot;,
;;;     :author_association &quot;NONE&quot;,
;;;     :number 288,
;;;     :milestone nil,
;;;     :repository_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter&quot;,
;;;     :comments 0,
;;;     :node_id &quot;MDU6SXNzdWU1OTQ3NDM3MjM=&quot;,
;;;     :state &quot;closed&quot;,
;;;     :title &quot;Transform all after FIRST&quot;,
;;;     :labels_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288/labels{/name}&quot;,
;;;     :updated_at &quot;2020-04-06T03:34:30Z&quot;,
;;;     :comments_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288/comments&quot;,
;;;     :locked false,
;;;     :id 594743723,
;;;     :events_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288/events&quot;,
;;;     :url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288&quot;,
;;;     :body
;;;     &quot;I&#x27;m working with a CSV file and I want to transform values and ignore the header.\r\n\r\nI can use `(let [header &amp; rows] csv)` but I&#x27;d like to be able to do this using specter without splitting out the headers separately.\r\n\r\nIs there an idiomatic way of doing this?&quot;,
;;;     :user
;;;     {:html_url &quot;https://github.com/stuartrexking&quot;,
;;;      :gravatar_id &quot;&quot;,
;;;      :followers_url
;;;      &quot;https://api.github.com/users/stuartrexking/followers&quot;,
;;;      :subscriptions_url
;;;      &quot;https://api.github.com/users/stuartrexking/subscriptions&quot;,
;;;      :site_admin false,
;;;      :following_url
;;;      &quot;https://api.github.com/users/stuartrexking/following{/other_user}&quot;,
;;;      :node_id &quot;MDQ6VXNlcjY1MjE0&quot;,
;;;      :type &quot;User&quot;,
;;;      :received_events_url
;;;      &quot;https://api.github.com/users/stuartrexking/received_events&quot;,
;;;      :login &quot;stuartrexking&quot;,
;;;      :organizations_url
;;;      &quot;https://api.github.com/users/stuartrexking/orgs&quot;,
;;;      :id 65214,
;;;      :events_url
;;;      &quot;https://api.github.com/users/stuartrexking/events{/privacy}&quot;,
;;;      :url &quot;https://api.github.com/users/stuartrexking&quot;,
;;;      :repos_url &quot;https://api.github.com/users/stuartrexking/repos&quot;,
;;;      :starred_url
;;;      &quot;https://api.github.com/users/stuartrexking/starred{/owner}{/repo}&quot;,
;;;      :gists_url
;;;      &quot;https://api.github.com/users/stuartrexking/gists{/gist_id}&quot;,
;;;      :avatar_url &quot;https://avatars0.githubusercontent.com/u/65214?v=4&quot;},
;;;     :assignee nil,
;;;     :created_at &quot;2020-04-06T01:19:22Z&quot;},
;;;    :comment
;;;    {:html_url
;;;     &quot;https://github.com/redplanetlabs/specter/issues/288#issuecomment-609547864&quot;,
;;;     :author_association &quot;COLLABORATOR&quot;,
;;;     :node_id &quot;MDEyOklzc3VlQ29tbWVudDYwOTU0Nzg2NA==&quot;,
;;;     :issue_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288&quot;,
;;;     :updated_at &quot;2020-04-06T03:34:30Z&quot;,
;;;     :id 609547864,
;;;     :url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/comments/609547864&quot;,
;;;     :body
;;;     &quot;You can do something like this:\r\n\r\n```clj\r\n(def REST (srange-dynamic (fn [_] 1) count))\r\n(transform [REST ALL] inc [1 2 3 4 5])\r\n;; =&gt; [1 3 4 5 6]\r\n```\r\n\r\n&quot;,
;;;     :user
;;;     {:html_url &quot;https://github.com/nathanmarz&quot;,
;;;      :gravatar_id &quot;&quot;,
;;;      :followers_url
;;;      &quot;https://api.github.com/users/nathanmarz/followers&quot;,
;;;      :subscriptions_url
;;;      &quot;https://api.github.com/users/nathanmarz/subscriptions&quot;,
;;;      :site_admin false,
;;;      :following_url
;;;      &quot;https://api.github.com/users/nathanmarz/following{/other_user}&quot;,
;;;      :node_id &quot;MDQ6VXNlcjEzMTQxNg==&quot;,
;;;      :type &quot;User&quot;,
;;;      :received_events_url
;;;      &quot;https://api.github.com/users/nathanmarz/received_events&quot;,
;;;      :login &quot;nathanmarz&quot;,
;;;      :organizations_url &quot;https://api.github.com/users/nathanmarz/orgs&quot;,
;;;      :id 131416,
;;;      :events_url
;;;      &quot;https://api.github.com/users/nathanmarz/events{/privacy}&quot;,
;;;      :url &quot;https://api.github.com/users/nathanmarz&quot;,
;;;      :repos_url &quot;https://api.github.com/users/nathanmarz/repos&quot;,
;;;      :starred_url
;;;      &quot;https://api.github.com/users/nathanmarz/starred{/owner}{/repo}&quot;,
;;;      :gists_url
;;;      &quot;https://api.github.com/users/nathanmarz/gists{/gist_id}&quot;,
;;;      :avatar_url
;;;      &quot;https://avatars0.githubusercontent.com/u/131416?v=4&quot;},
;;;     :created_at &quot;2020-04-06T03:34:30Z&quot;}},
;;;   :public true,
;;;   :created_at &quot;2020-04-06T03:34:30Z&quot;,
;;;   :org
;;;   {:id 2371803,
;;;    :login &quot;redplanetlabs&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/orgs/redplanetlabs&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/2371803?&quot;}}
;;;  {:id &quot;11965893624&quot;,
;;;   :type &quot;IssuesEvent&quot;,
;;;   :actor
;;;   {:id 65214,
;;;    :login &quot;stuartrexking&quot;,
;;;    :display_login &quot;stuartrexking&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/users/stuartrexking&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/65214?&quot;},
;;;   :repo
;;;   {:id 31374926,
;;;    :name &quot;redplanetlabs/specter&quot;,
;;;    :url &quot;https://api.github.com/repos/redplanetlabs/specter&quot;},
;;;   :payload
;;;   {:action &quot;opened&quot;,
;;;    :issue
;;;    {:html_url &quot;https://github.com/redplanetlabs/specter/issues/288&quot;,
;;;     :labels [],
;;;     :assignees [],
;;;     :closed_at nil,
;;;     :author_association &quot;NONE&quot;,
;;;     :number 288,
;;;     :milestone nil,
;;;     :repository_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter&quot;,
;;;     :comments 0,
;;;     :node_id &quot;MDU6SXNzdWU1OTQ3NDM3MjM=&quot;,
;;;     :state &quot;open&quot;,
;;;     :title &quot;Transform all after FIRST&quot;,
;;;     :labels_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288/labels{/name}&quot;,
;;;     :updated_at &quot;2020-04-06T01:19:22Z&quot;,
;;;     :comments_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288/comments&quot;,
;;;     :locked false,
;;;     :id 594743723,
;;;     :events_url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288/events&quot;,
;;;     :url
;;;     &quot;https://api.github.com/repos/redplanetlabs/specter/issues/288&quot;,
;;;     :body
;;;     &quot;I&#x27;m working with a CSV file and I want to transform values and ignore the header.\r\n\r\nI can use `(let [header &amp; rows] csv)` but I&#x27;d like to be able to do this using specter without splitting out the headers separately.\r\n\r\nIs there an idiomatic way of doing this?&quot;,
;;;     :user
;;;     {:html_url &quot;https://github.com/stuartrexking&quot;,
;;;      :gravatar_id &quot;&quot;,
;;;      :followers_url
;;;      &quot;https://api.github.com/users/stuartrexking/followers&quot;,
;;;      :subscriptions_url
;;;      &quot;https://api.github.com/users/stuartrexking/subscriptions&quot;,
;;;      :site_admin false,
;;;      :following_url
;;;      &quot;https://api.github.com/users/stuartrexking/following{/other_user}&quot;,
;;;      :node_id &quot;MDQ6VXNlcjY1MjE0&quot;,
;;;      :type &quot;User&quot;,
;;;      :received_events_url
;;;      &quot;https://api.github.com/users/stuartrexking/received_events&quot;,
;;;      :login &quot;stuartrexking&quot;,
;;;      :organizations_url
;;;      &quot;https://api.github.com/users/stuartrexking/orgs&quot;,
;;;      :id 65214,
;;;      :events_url
;;;      &quot;https://api.github.com/users/stuartrexking/events{/privacy}&quot;,
;;;      :url &quot;https://api.github.com/users/stuartrexking&quot;,
;;;      :repos_url &quot;https://api.github.com/users/stuartrexking/repos&quot;,
;;;      :starred_url
;;;      &quot;https://api.github.com/users/stuartrexking/starred{/owner}{/repo}&quot;,
;;;      :gists_url
;;;      &quot;https://api.github.com/users/stuartrexking/gists{/gist_id}&quot;,
;;;      :avatar_url &quot;https://avatars0.githubusercontent.com/u/65214?v=4&quot;},
;;;     :assignee nil,
;;;     :created_at &quot;2020-04-06T01:19:22Z&quot;}},
;;;   :public true,
;;;   :created_at &quot;2020-04-06T01:19:22Z&quot;,
;;;   :org
;;;   {:id 2371803,
;;;    :login &quot;redplanetlabs&quot;,
;;;    :gravatar_id &quot;&quot;,
;;;    :url &quot;https://api.github.com/orgs/redplanetlabs&quot;,
;;;    :avatar_url &quot;https://avatars.githubusercontent.com/u/2371803?&quot;}})
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(->> (gitapi/user-events "jeffatatl")
     (map :type))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""}],"value":"(\"IssuesEvent\" \"IssueCommentEvent\" \"IssuesEvent\" \"IssuesEvent\" \"IssueCommentEvent\" \"IssuesEvent\")"}
;; <=

;; @@
(dir tentacles.events)
;; @@
;; ->
;;; events
;;; issue-events
;;; network-events
;;; org-events
;;; performed-events
;;; repo-events
;;; user-events
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc gitapi/events)
;; @@
;; ->
;;; -------------------------
;;; tentacles.events/events
;;; ([&amp; [options]])
;;;   List public events.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(->> (gitapi/events)
     count)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>30</span>","value":"30"}
;; <=

;; @@
(->> (gitapi/events)
     first
     keys)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(:id :type :actor :repo :payload :public :created_at)</span>","value":"(:id :type :actor :repo :payload :public :created_at)"}
;; <=

;; @@
(->> (gitapi/events)
     first
     :payload
     keys)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"}
;; <=

;; @@
(defn score-event-type
  "Takes an event type (String) and returns a number score (Number)."
  [t]
  (let [event-score-map {
                         "PushEvent" 5
                         "PullRequestReviewCommentEvent" 4
                         "WatchEvent" 3
                         "CreateEvent" 2
                        }
        score (get event-score-map t 1)]
    score
    ))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;rentpath-scoring-service/score-event-type</span>","value":"#'rentpath-scoring-service/score-event-type"}
;; <=

;; @@
(score-event-type "PushEvent")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}
;; <=

;; @@
(score-event-type "PullRequestReviewCommentEvent")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}
;; <=

;; @@
(score-event-type "WatchEvent")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}
;; <=

;; @@
(score-event-type "CreateEvent")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
(score-event-type "AnyEvent")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}
;; <=

;; @@
(->> (gitapi/events)
     (map (juxt :id 
                (comp :name :repo) 
                (comp keys :payload) 
                :type 
                (comp :login :actor) 
                (comp score-event-type :type) 
                :created_at))
     (sort-by first)
     (apply map list)
     (concat (list (rest (range))))
     (apply map list)
     table-view
     )
;; @@
;; =>
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;12668470346&quot;</span>","value":"\"12668470346\""},{"type":"html","content":"<span class='clj-string'>&quot;cistuss/springboot-demo&quot;</span>","value":"\"cistuss/springboot-demo\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;cistuss&quot;</span>","value":"\"cistuss\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:19Z&quot;</span>","value":"\"2020-06-18T12:34:19Z\""}],"value":"(1 \"12668470346\" \"cistuss/springboot-demo\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"cistuss\" 5 \"2020-06-18T12:34:19Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;12668470374&quot;</span>","value":"\"12668470374\""},{"type":"html","content":"<span class='clj-string'>&quot;va1entei/puszcza_cam1&quot;</span>","value":"\"va1entei/puszcza_cam1\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;va1entei&quot;</span>","value":"\"va1entei\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:19Z&quot;</span>","value":"\"2020-06-18T12:34:19Z\""}],"value":"(2 \"12668470374\" \"va1entei/puszcza_cam1\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"va1entei\" 5 \"2020-06-18T12:34:19Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-string'>&quot;12668470380&quot;</span>","value":"\"12668470380\""},{"type":"html","content":"<span class='clj-string'>&quot;ClairevanBlerck/clairevanblerck.github.io&quot;</span>","value":"\"ClairevanBlerck/clairevanblerck.github.io\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;ClairevanBlerck&quot;</span>","value":"\"ClairevanBlerck\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:19Z&quot;</span>","value":"\"2020-06-18T12:34:19Z\""}],"value":"(3 \"12668470380\" \"ClairevanBlerck/clairevanblerck.github.io\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"ClairevanBlerck\" 5 \"2020-06-18T12:34:19Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-string'>&quot;12668470387&quot;</span>","value":"\"12668470387\""},{"type":"html","content":"<span class='clj-string'>&quot;Meoji/Discord-Bots&quot;</span>","value":"\"Meoji/Discord-Bots\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Meoji&quot;</span>","value":"\"Meoji\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:19Z&quot;</span>","value":"\"2020-06-18T12:34:19Z\""}],"value":"(4 \"12668470387\" \"Meoji/Discord-Bots\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Meoji\" 5 \"2020-06-18T12:34:19Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;12668470388&quot;</span>","value":"\"12668470388\""},{"type":"html","content":"<span class='clj-string'>&quot;internet-help-zone-shihab/zPhisher&quot;</span>","value":"\"internet-help-zone-shihab/zPhisher\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;internet-help-zone-shihab&quot;</span>","value":"\"internet-help-zone-shihab\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:19Z&quot;</span>","value":"\"2020-06-18T12:34:19Z\""}],"value":"(5 \"12668470388\" \"internet-help-zone-shihab/zPhisher\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"internet-help-zone-shihab\" 5 \"2020-06-18T12:34:19Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-string'>&quot;12668470389&quot;</span>","value":"\"12668470389\""},{"type":"html","content":"<span class='clj-string'>&quot;Smile977/my-excel&quot;</span>","value":"\"Smile977/my-excel\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Smile977&quot;</span>","value":"\"Smile977\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:19Z&quot;</span>","value":"\"2020-06-18T12:34:19Z\""}],"value":"(6 \"12668470389\" \"Smile977/my-excel\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Smile977\" 5 \"2020-06-18T12:34:19Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-string'>&quot;12668470402&quot;</span>","value":"\"12668470402\""},{"type":"html","content":"<span class='clj-string'>&quot;Michael-200/Homework.C-sharp&quot;</span>","value":"\"Michael-200/Homework.C-sharp\""},{"type":"html","content":"<span class='clj-unkown'>(:action :number :pull_request)</span>","value":"(:action :number :pull_request)"},{"type":"html","content":"<span class='clj-string'>&quot;PullRequestEvent&quot;</span>","value":"\"PullRequestEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Michael-200&quot;</span>","value":"\"Michael-200\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:19Z&quot;</span>","value":"\"2020-06-18T12:34:19Z\""}],"value":"(7 \"12668470402\" \"Michael-200/Homework.C-sharp\" (:action :number :pull_request) \"PullRequestEvent\" \"Michael-200\" 1 \"2020-06-18T12:34:19Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-string'>&quot;12668470409&quot;</span>","value":"\"12668470409\""},{"type":"html","content":"<span class='clj-string'>&quot;Rellinxe27/Proj01&quot;</span>","value":"\"Rellinxe27/Proj01\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Rellinxe27&quot;</span>","value":"\"Rellinxe27\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:19Z&quot;</span>","value":"\"2020-06-18T12:34:19Z\""}],"value":"(8 \"12668470409\" \"Rellinxe27/Proj01\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"Rellinxe27\" 2 \"2020-06-18T12:34:19Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-string'>&quot;12668470424&quot;</span>","value":"\"12668470424\""},{"type":"html","content":"<span class='clj-string'>&quot;webis-de/downloads&quot;</span>","value":"\"webis-de/downloads\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;phoerious&quot;</span>","value":"\"phoerious\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(9 \"12668470424\" \"webis-de/downloads\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"phoerious\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-string'>&quot;12668470427&quot;</span>","value":"\"12668470427\""},{"type":"html","content":"<span class='clj-string'>&quot;Prashwarmishra/Learn-Git-and-GitHub&quot;</span>","value":"\"Prashwarmishra/Learn-Git-and-GitHub\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Prashwarmishra&quot;</span>","value":"\"Prashwarmishra\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(10 \"12668470427\" \"Prashwarmishra/Learn-Git-and-GitHub\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"Prashwarmishra\" 2 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>11</span>","value":"11"},{"type":"html","content":"<span class='clj-string'>&quot;12668470432&quot;</span>","value":"\"12668470432\""},{"type":"html","content":"<span class='clj-string'>&quot;martin-prikryl/primes&quot;</span>","value":"\"martin-prikryl/primes\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;martin-prikryl&quot;</span>","value":"\"martin-prikryl\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(11 \"12668470432\" \"martin-prikryl/primes\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"martin-prikryl\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-string'>&quot;12668470437&quot;</span>","value":"\"12668470437\""},{"type":"html","content":"<span class='clj-string'>&quot;xon-dev/pacwall&quot;</span>","value":"\"xon-dev/pacwall\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;xon-dev&quot;</span>","value":"\"xon-dev\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(12 \"12668470437\" \"xon-dev/pacwall\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"xon-dev\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>13</span>","value":"13"},{"type":"html","content":"<span class='clj-string'>&quot;12668470439&quot;</span>","value":"\"12668470439\""},{"type":"html","content":"<span class='clj-string'>&quot;CookPete/react-player&quot;</span>","value":"\"CookPete/react-player\""},{"type":"html","content":"<span class='clj-unkown'>(:action)</span>","value":"(:action)"},{"type":"html","content":"<span class='clj-string'>&quot;WatchEvent&quot;</span>","value":"\"WatchEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;zhangyuiris&quot;</span>","value":"\"zhangyuiris\""},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(13 \"12668470439\" \"CookPete/react-player\" (:action) \"WatchEvent\" \"zhangyuiris\" 3 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-string'>&quot;12668470443&quot;</span>","value":"\"12668470443\""},{"type":"html","content":"<span class='clj-string'>&quot;BROprogramma/HGM&quot;</span>","value":"\"BROprogramma/HGM\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;adbgnm&quot;</span>","value":"\"adbgnm\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(14 \"12668470443\" \"BROprogramma/HGM\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"adbgnm\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>15</span>","value":"15"},{"type":"html","content":"<span class='clj-string'>&quot;12668470446&quot;</span>","value":"\"12668470446\""},{"type":"html","content":"<span class='clj-string'>&quot;balena-io/open-balena-api&quot;</span>","value":"\"balena-io/open-balena-api\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Page-&quot;</span>","value":"\"Page-\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(15 \"12668470446\" \"balena-io/open-balena-api\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"Page-\" 2 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-string'>&quot;12668470449&quot;</span>","value":"\"12668470449\""},{"type":"html","content":"<span class='clj-string'>&quot;luisbtejada/test1&quot;</span>","value":"\"luisbtejada/test1\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;luisbtejada&quot;</span>","value":"\"luisbtejada\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(16 \"12668470449\" \"luisbtejada/test1\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"luisbtejada\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>17</span>","value":"17"},{"type":"html","content":"<span class='clj-string'>&quot;12668470467&quot;</span>","value":"\"12668470467\""},{"type":"html","content":"<span class='clj-string'>&quot;premasai09/module2-solution&quot;</span>","value":"\"premasai09/module2-solution\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;premasai09&quot;</span>","value":"\"premasai09\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(17 \"12668470467\" \"premasai09/module2-solution\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"premasai09\" 2 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"},{"type":"html","content":"<span class='clj-string'>&quot;12668470471&quot;</span>","value":"\"12668470471\""},{"type":"html","content":"<span class='clj-string'>&quot;umeshraj/youtube_colt_code_camp&quot;</span>","value":"\"umeshraj/youtube_colt_code_camp\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;umeshraj&quot;</span>","value":"\"umeshraj\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(18 \"12668470471\" \"umeshraj/youtube_colt_code_camp\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"umeshraj\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>19</span>","value":"19"},{"type":"html","content":"<span class='clj-string'>&quot;12668470472&quot;</span>","value":"\"12668470472\""},{"type":"html","content":"<span class='clj-string'>&quot;IBM/route-reflector-operator&quot;</span>","value":"\"IBM/route-reflector-operator\""},{"type":"html","content":"<span class='clj-unkown'>(:action :number :pull_request)</span>","value":"(:action :number :pull_request)"},{"type":"html","content":"<span class='clj-string'>&quot;PullRequestEvent&quot;</span>","value":"\"PullRequestEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;mihalysz22&quot;</span>","value":"\"mihalysz22\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(19 \"12668470472\" \"IBM/route-reflector-operator\" (:action :number :pull_request) \"PullRequestEvent\" \"mihalysz22\" 1 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>20</span>","value":"20"},{"type":"html","content":"<span class='clj-string'>&quot;12668470473&quot;</span>","value":"\"12668470473\""},{"type":"html","content":"<span class='clj-string'>&quot;vuorenkoski/sudoku-solver&quot;</span>","value":"\"vuorenkoski/sudoku-solver\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;vuorenkoski&quot;</span>","value":"\"vuorenkoski\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(20 \"12668470473\" \"vuorenkoski/sudoku-solver\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"vuorenkoski\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>21</span>","value":"21"},{"type":"html","content":"<span class='clj-string'>&quot;12668470480&quot;</span>","value":"\"12668470480\""},{"type":"html","content":"<span class='clj-string'>&quot;percona/grafana-dashboards&quot;</span>","value":"\"percona/grafana-dashboards\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;codecov[bot]&quot;</span>","value":"\"codecov[bot]\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(21 \"12668470480\" \"percona/grafana-dashboards\" (:action :issue :comment) \"IssueCommentEvent\" \"codecov[bot]\" 1 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>22</span>","value":"22"},{"type":"html","content":"<span class='clj-string'>&quot;12668470482&quot;</span>","value":"\"12668470482\""},{"type":"html","content":"<span class='clj-string'>&quot;tecmz/parttime&quot;</span>","value":"\"tecmz/parttime\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;tecmz&quot;</span>","value":"\"tecmz\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(22 \"12668470482\" \"tecmz/parttime\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"tecmz\" 2 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>23</span>","value":"23"},{"type":"html","content":"<span class='clj-string'>&quot;12668470489&quot;</span>","value":"\"12668470489\""},{"type":"html","content":"<span class='clj-string'>&quot;nFiddleFox/github-slideshow&quot;</span>","value":"\"nFiddleFox/github-slideshow\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;github-learning-lab[bot]&quot;</span>","value":"\"github-learning-lab[bot]\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(23 \"12668470489\" \"nFiddleFox/github-slideshow\" (:action :issue :comment) \"IssueCommentEvent\" \"github-learning-lab[bot]\" 1 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>24</span>","value":"24"},{"type":"html","content":"<span class='clj-string'>&quot;12668470490&quot;</span>","value":"\"12668470490\""},{"type":"html","content":"<span class='clj-string'>&quot;highmobility/auto-api&quot;</span>","value":"\"highmobility/auto-api\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;doofyus&quot;</span>","value":"\"doofyus\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(24 \"12668470490\" \"highmobility/auto-api\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"doofyus\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>25</span>","value":"25"},{"type":"html","content":"<span class='clj-string'>&quot;12668470494&quot;</span>","value":"\"12668470494\""},{"type":"html","content":"<span class='clj-string'>&quot;Ryocon/Jetbrains&quot;</span>","value":"\"Ryocon/Jetbrains\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Ryocon&quot;</span>","value":"\"Ryocon\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(25 \"12668470494\" \"Ryocon/Jetbrains\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Ryocon\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>26</span>","value":"26"},{"type":"html","content":"<span class='clj-string'>&quot;12668470495&quot;</span>","value":"\"12668470495\""},{"type":"html","content":"<span class='clj-string'>&quot;vijaypolsani/openl-tablets&quot;</span>","value":"\"vijaypolsani/openl-tablets\""},{"type":"html","content":"<span class='clj-unkown'>(:action :number :pull_request)</span>","value":"(:action :number :pull_request)"},{"type":"html","content":"<span class='clj-string'>&quot;PullRequestEvent&quot;</span>","value":"\"PullRequestEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;pull[bot]&quot;</span>","value":"\"pull[bot]\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(26 \"12668470495\" \"vijaypolsani/openl-tablets\" (:action :number :pull_request) \"PullRequestEvent\" \"pull[bot]\" 1 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>27</span>","value":"27"},{"type":"html","content":"<span class='clj-string'>&quot;12668470496&quot;</span>","value":"\"12668470496\""},{"type":"html","content":"<span class='clj-string'>&quot;Spoience/pic&quot;</span>","value":"\"Spoience/pic\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Spoience&quot;</span>","value":"\"Spoience\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(27 \"12668470496\" \"Spoience/pic\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Spoience\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>28</span>","value":"28"},{"type":"html","content":"<span class='clj-string'>&quot;12668470500&quot;</span>","value":"\"12668470500\""},{"type":"html","content":"<span class='clj-string'>&quot;Nosto/lazysusan&quot;</span>","value":"\"Nosto/lazysusan\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;gary-madden&quot;</span>","value":"\"gary-madden\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(28 \"12668470500\" \"Nosto/lazysusan\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"gary-madden\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>29</span>","value":"29"},{"type":"html","content":"<span class='clj-string'>&quot;12668470517&quot;</span>","value":"\"12668470517\""},{"type":"html","content":"<span class='clj-string'>&quot;Sakshi249/coursera-test&quot;</span>","value":"\"Sakshi249/coursera-test\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Sakshi249&quot;</span>","value":"\"Sakshi249\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(29 \"12668470517\" \"Sakshi249/coursera-test\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Sakshi249\" 5 \"2020-06-18T12:34:20Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>30</span>","value":"30"},{"type":"html","content":"<span class='clj-string'>&quot;12668470528&quot;</span>","value":"\"12668470528\""},{"type":"html","content":"<span class='clj-string'>&quot;simplifier-ag/docs&quot;</span>","value":"\"simplifier-ag/docs\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;chrisbouveret&quot;</span>","value":"\"chrisbouveret\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-18T12:34:20Z&quot;</span>","value":"\"2020-06-18T12:34:20Z\""}],"value":"(30 \"12668470528\" \"simplifier-ag/docs\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"chrisbouveret\" 5 \"2020-06-18T12:34:20Z\")"}],"value":"#gorilla_repl.table.TableView{:contents ((1 \"12668470346\" \"cistuss/springboot-demo\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"cistuss\" 5 \"2020-06-18T12:34:19Z\") (2 \"12668470374\" \"va1entei/puszcza_cam1\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"va1entei\" 5 \"2020-06-18T12:34:19Z\") (3 \"12668470380\" \"ClairevanBlerck/clairevanblerck.github.io\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"ClairevanBlerck\" 5 \"2020-06-18T12:34:19Z\") (4 \"12668470387\" \"Meoji/Discord-Bots\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Meoji\" 5 \"2020-06-18T12:34:19Z\") (5 \"12668470388\" \"internet-help-zone-shihab/zPhisher\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"internet-help-zone-shihab\" 5 \"2020-06-18T12:34:19Z\") (6 \"12668470389\" \"Smile977/my-excel\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Smile977\" 5 \"2020-06-18T12:34:19Z\") (7 \"12668470402\" \"Michael-200/Homework.C-sharp\" (:action :number :pull_request) \"PullRequestEvent\" \"Michael-200\" 1 \"2020-06-18T12:34:19Z\") (8 \"12668470409\" \"Rellinxe27/Proj01\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"Rellinxe27\" 2 \"2020-06-18T12:34:19Z\") (9 \"12668470424\" \"webis-de/downloads\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"phoerious\" 5 \"2020-06-18T12:34:20Z\") (10 \"12668470427\" \"Prashwarmishra/Learn-Git-and-GitHub\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"Prashwarmishra\" 2 \"2020-06-18T12:34:20Z\") (11 \"12668470432\" \"martin-prikryl/primes\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"martin-prikryl\" 5 \"2020-06-18T12:34:20Z\") (12 \"12668470437\" \"xon-dev/pacwall\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"xon-dev\" 5 \"2020-06-18T12:34:20Z\") (13 \"12668470439\" \"CookPete/react-player\" (:action) \"WatchEvent\" \"zhangyuiris\" 3 \"2020-06-18T12:34:20Z\") (14 \"12668470443\" \"BROprogramma/HGM\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"adbgnm\" 5 \"2020-06-18T12:34:20Z\") (15 \"12668470446\" \"balena-io/open-balena-api\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"Page-\" 2 \"2020-06-18T12:34:20Z\") (16 \"12668470449\" \"luisbtejada/test1\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"luisbtejada\" 5 \"2020-06-18T12:34:20Z\") (17 \"12668470467\" \"premasai09/module2-solution\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"premasai09\" 2 \"2020-06-18T12:34:20Z\") (18 \"12668470471\" \"umeshraj/youtube_colt_code_camp\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"umeshraj\" 5 \"2020-06-18T12:34:20Z\") (19 \"12668470472\" \"IBM/route-reflector-operator\" (:action :number :pull_request) \"PullRequestEvent\" \"mihalysz22\" 1 \"2020-06-18T12:34:20Z\") (20 \"12668470473\" \"vuorenkoski/sudoku-solver\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"vuorenkoski\" 5 \"2020-06-18T12:34:20Z\") (21 \"12668470480\" \"percona/grafana-dashboards\" (:action :issue :comment) \"IssueCommentEvent\" \"codecov[bot]\" 1 \"2020-06-18T12:34:20Z\") (22 \"12668470482\" \"tecmz/parttime\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"tecmz\" 2 \"2020-06-18T12:34:20Z\") (23 \"12668470489\" \"nFiddleFox/github-slideshow\" (:action :issue :comment) \"IssueCommentEvent\" \"github-learning-lab[bot]\" 1 \"2020-06-18T12:34:20Z\") (24 \"12668470490\" \"highmobility/auto-api\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"doofyus\" 5 \"2020-06-18T12:34:20Z\") (25 \"12668470494\" \"Ryocon/Jetbrains\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Ryocon\" 5 \"2020-06-18T12:34:20Z\") (26 \"12668470495\" \"vijaypolsani/openl-tablets\" (:action :number :pull_request) \"PullRequestEvent\" \"pull[bot]\" 1 \"2020-06-18T12:34:20Z\") (27 \"12668470496\" \"Spoience/pic\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Spoience\" 5 \"2020-06-18T12:34:20Z\") (28 \"12668470500\" \"Nosto/lazysusan\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"gary-madden\" 5 \"2020-06-18T12:34:20Z\") (29 \"12668470517\" \"Sakshi249/coursera-test\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Sakshi249\" 5 \"2020-06-18T12:34:20Z\") (30 \"12668470528\" \"simplifier-ag/docs\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"chrisbouveret\" 5 \"2020-06-18T12:34:20Z\")), :opts nil}"}
;; <=

;; @@

;; @@
;; ->
;;; -------------------------
;;; clojure.core/defn
;;; ([name doc-string? attr-map? [params*] prepost-map? body] [name doc-string? attr-map? ([params*] prepost-map? body) + attr-map?])
;;; Macro
;;;   Same as (def name (fn [params* ] exprs*)) or (def
;;;     name (fn ([params* ] exprs*)+)) with any doc-string or attrs added
;;;     to the var metadata. prepost-map defines a map with optional keys
;;;     :pre and :post that contain collections of pre or post conditions.
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
