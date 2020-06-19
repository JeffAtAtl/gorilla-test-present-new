;; gorilla-repl.fileformat = 1

;; **
;;; # Rentpath Scoring Service
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
  (:require [tentacles.repos :as gitapirepo])
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
     (map :type))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""}],"value":"(\"IssuesEvent\" \"IssueCommentEvent\" \"IssuesEvent\" \"IssuesEvent\" \"IssueCommentEvent\" \"IssuesEvent\")"}
;; <=

;; @@
(->> (gitapi/user-events "jeffatatl")
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
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;11965893624&quot;</span>","value":"\"11965893624\""},{"type":"html","content":"<span class='clj-string'>&quot;redplanetlabs/specter&quot;</span>","value":"\"redplanetlabs/specter\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue)</span>","value":"(:action :issue)"},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;stuartrexking&quot;</span>","value":"\"stuartrexking\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-04-06T01:19:22Z&quot;</span>","value":"\"2020-04-06T01:19:22Z\""}],"value":"(1 \"11965893624\" \"redplanetlabs/specter\" (:action :issue) \"IssuesEvent\" \"stuartrexking\" 1 \"2020-04-06T01:19:22Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;11966464542&quot;</span>","value":"\"11966464542\""},{"type":"html","content":"<span class='clj-string'>&quot;redplanetlabs/specter&quot;</span>","value":"\"redplanetlabs/specter\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;nathanmarz&quot;</span>","value":"\"nathanmarz\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-04-06T03:34:30Z&quot;</span>","value":"\"2020-04-06T03:34:30Z\""}],"value":"(2 \"11966464542\" \"redplanetlabs/specter\" (:action :issue :comment) \"IssueCommentEvent\" \"nathanmarz\" 1 \"2020-04-06T03:34:30Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-string'>&quot;11966464563&quot;</span>","value":"\"11966464563\""},{"type":"html","content":"<span class='clj-string'>&quot;redplanetlabs/specter&quot;</span>","value":"\"redplanetlabs/specter\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue)</span>","value":"(:action :issue)"},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;nathanmarz&quot;</span>","value":"\"nathanmarz\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-04-06T03:34:30Z&quot;</span>","value":"\"2020-04-06T03:34:30Z\""}],"value":"(3 \"11966464563\" \"redplanetlabs/specter\" (:action :issue) \"IssuesEvent\" \"nathanmarz\" 1 \"2020-04-06T03:34:30Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-string'>&quot;12621095098&quot;</span>","value":"\"12621095098\""},{"type":"html","content":"<span class='clj-string'>&quot;redplanetlabs/specter&quot;</span>","value":"\"redplanetlabs/specter\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue)</span>","value":"(:action :issue)"},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;mbertheau&quot;</span>","value":"\"mbertheau\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-13T10:32:54Z&quot;</span>","value":"\"2020-06-13T10:32:54Z\""}],"value":"(4 \"12621095098\" \"redplanetlabs/specter\" (:action :issue) \"IssuesEvent\" \"mbertheau\" 1 \"2020-06-13T10:32:54Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;12623211483&quot;</span>","value":"\"12623211483\""},{"type":"html","content":"<span class='clj-string'>&quot;redplanetlabs/specter&quot;</span>","value":"\"redplanetlabs/specter\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;nathanmarz&quot;</span>","value":"\"nathanmarz\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-13T21:29:35Z&quot;</span>","value":"\"2020-06-13T21:29:35Z\""}],"value":"(5 \"12623211483\" \"redplanetlabs/specter\" (:action :issue :comment) \"IssueCommentEvent\" \"nathanmarz\" 1 \"2020-06-13T21:29:35Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-string'>&quot;12623211499&quot;</span>","value":"\"12623211499\""},{"type":"html","content":"<span class='clj-string'>&quot;redplanetlabs/specter&quot;</span>","value":"\"redplanetlabs/specter\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue)</span>","value":"(:action :issue)"},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;nathanmarz&quot;</span>","value":"\"nathanmarz\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-13T21:29:36Z&quot;</span>","value":"\"2020-06-13T21:29:36Z\""}],"value":"(6 \"12623211499\" \"redplanetlabs/specter\" (:action :issue) \"IssuesEvent\" \"nathanmarz\" 1 \"2020-06-13T21:29:36Z\")"}],"value":"#gorilla_repl.table.TableView{:contents ((1 \"11965893624\" \"redplanetlabs/specter\" (:action :issue) \"IssuesEvent\" \"stuartrexking\" 1 \"2020-04-06T01:19:22Z\") (2 \"11966464542\" \"redplanetlabs/specter\" (:action :issue :comment) \"IssueCommentEvent\" \"nathanmarz\" 1 \"2020-04-06T03:34:30Z\") (3 \"11966464563\" \"redplanetlabs/specter\" (:action :issue) \"IssuesEvent\" \"nathanmarz\" 1 \"2020-04-06T03:34:30Z\") (4 \"12621095098\" \"redplanetlabs/specter\" (:action :issue) \"IssuesEvent\" \"mbertheau\" 1 \"2020-06-13T10:32:54Z\") (5 \"12623211483\" \"redplanetlabs/specter\" (:action :issue :comment) \"IssueCommentEvent\" \"nathanmarz\" 1 \"2020-06-13T21:29:35Z\") (6 \"12623211499\" \"redplanetlabs/specter\" (:action :issue) \"IssuesEvent\" \"nathanmarz\" 1 \"2020-06-13T21:29:36Z\")), :opts nil}"}
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

;; @@

;; @@
(->> (gitapi/performed-events "jeffatatl")
     count)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>4</span>","value":"4"}
;; <=

;; @@
(->> (gitapi/performed-events "jeffatatl")
     first
     keys)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(:id :type :actor :repo :payload :public :created_at)</span>","value":"(:id :type :actor :repo :payload :public :created_at)"}
;; <=

;; @@
(->> (gitapi/performed-events "jeffatatl")
     (map :type))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""}],"value":"(\"PushEvent\" \"PushEvent\" \"CreateEvent\" \"CreateEvent\")"}
;; <=

;; @@
(->> (gitapi/performed-events "jeffatatl")
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
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;12651565274&quot;</span>","value":"\"12651565274\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl/ScoringService&quot;</span>","value":"\"JeffAtAtl/ScoringService\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl&quot;</span>","value":"\"JeffAtAtl\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-17T00:44:30Z&quot;</span>","value":"\"2020-06-17T00:44:30Z\""}],"value":"(1 \"12651565274\" \"JeffAtAtl/ScoringService\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-17T00:44:30Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;12651565439&quot;</span>","value":"\"12651565439\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl/ScoringService&quot;</span>","value":"\"JeffAtAtl/ScoringService\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl&quot;</span>","value":"\"JeffAtAtl\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-17T00:44:32Z&quot;</span>","value":"\"2020-06-17T00:44:32Z\""}],"value":"(2 \"12651565439\" \"JeffAtAtl/ScoringService\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-17T00:44:32Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-string'>&quot;12651572132&quot;</span>","value":"\"12651572132\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl/ScoringService&quot;</span>","value":"\"JeffAtAtl/ScoringService\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl&quot;</span>","value":"\"JeffAtAtl\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-17T00:45:57Z&quot;</span>","value":"\"2020-06-17T00:45:57Z\""}],"value":"(3 \"12651572132\" \"JeffAtAtl/ScoringService\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"JeffAtAtl\" 5 \"2020-06-17T00:45:57Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-string'>&quot;12651796987&quot;</span>","value":"\"12651796987\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl/ScoringService&quot;</span>","value":"\"JeffAtAtl/ScoringService\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl&quot;</span>","value":"\"JeffAtAtl\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-17T01:31:22Z&quot;</span>","value":"\"2020-06-17T01:31:22Z\""}],"value":"(4 \"12651796987\" \"JeffAtAtl/ScoringService\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"JeffAtAtl\" 5 \"2020-06-17T01:31:22Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;12675297708&quot;</span>","value":"\"12675297708\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl/gorilla-test-present&quot;</span>","value":"\"JeffAtAtl/gorilla-test-present\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl&quot;</span>","value":"\"JeffAtAtl\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T01:13:10Z&quot;</span>","value":"\"2020-06-19T01:13:10Z\""}],"value":"(5 \"12675297708\" \"JeffAtAtl/gorilla-test-present\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-19T01:13:10Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-string'>&quot;12675375570&quot;</span>","value":"\"12675375570\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl/gorilla-test-present-new&quot;</span>","value":"\"JeffAtAtl/gorilla-test-present-new\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl&quot;</span>","value":"\"JeffAtAtl\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T01:29:31Z&quot;</span>","value":"\"2020-06-19T01:29:31Z\""}],"value":"(6 \"12675375570\" \"JeffAtAtl/gorilla-test-present-new\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-19T01:29:31Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-string'>&quot;12675462541&quot;</span>","value":"\"12675462541\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl/gorilla-test-present-new&quot;</span>","value":"\"JeffAtAtl/gorilla-test-present-new\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl&quot;</span>","value":"\"JeffAtAtl\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T01:47:40Z&quot;</span>","value":"\"2020-06-19T01:47:40Z\""}],"value":"(7 \"12675462541\" \"JeffAtAtl/gorilla-test-present-new\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-19T01:47:40Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-string'>&quot;12675521718&quot;</span>","value":"\"12675521718\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl/gorilla-test-present-new&quot;</span>","value":"\"JeffAtAtl/gorilla-test-present-new\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl&quot;</span>","value":"\"JeffAtAtl\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:00:08Z&quot;</span>","value":"\"2020-06-19T02:00:08Z\""}],"value":"(8 \"12675521718\" \"JeffAtAtl/gorilla-test-present-new\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"JeffAtAtl\" 5 \"2020-06-19T02:00:08Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-string'>&quot;12675631441&quot;</span>","value":"\"12675631441\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl/gorilla-test-present-new&quot;</span>","value":"\"JeffAtAtl/gorilla-test-present-new\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;JeffAtAtl&quot;</span>","value":"\"JeffAtAtl\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:22:01Z&quot;</span>","value":"\"2020-06-19T02:22:01Z\""}],"value":"(9 \"12675631441\" \"JeffAtAtl/gorilla-test-present-new\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"JeffAtAtl\" 5 \"2020-06-19T02:22:01Z\")"}],"value":"#gorilla_repl.table.TableView{:contents ((1 \"12651565274\" \"JeffAtAtl/ScoringService\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-17T00:44:30Z\") (2 \"12651565439\" \"JeffAtAtl/ScoringService\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-17T00:44:32Z\") (3 \"12651572132\" \"JeffAtAtl/ScoringService\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"JeffAtAtl\" 5 \"2020-06-17T00:45:57Z\") (4 \"12651796987\" \"JeffAtAtl/ScoringService\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"JeffAtAtl\" 5 \"2020-06-17T01:31:22Z\") (5 \"12675297708\" \"JeffAtAtl/gorilla-test-present\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-19T01:13:10Z\") (6 \"12675375570\" \"JeffAtAtl/gorilla-test-present-new\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-19T01:29:31Z\") (7 \"12675462541\" \"JeffAtAtl/gorilla-test-present-new\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"JeffAtAtl\" 2 \"2020-06-19T01:47:40Z\") (8 \"12675521718\" \"JeffAtAtl/gorilla-test-present-new\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"JeffAtAtl\" 5 \"2020-06-19T02:00:08Z\") (9 \"12675631441\" \"JeffAtAtl/gorilla-test-present-new\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"JeffAtAtl\" 5 \"2020-06-19T02:22:01Z\")), :opts nil}"}
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
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;12675650283&quot;</span>","value":"\"12675650283\""},{"type":"html","content":"<span class='clj-string'>&quot;GundalaNikhil/Vehicle-Detection&quot;</span>","value":"\"GundalaNikhil/Vehicle-Detection\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;GundalaNikhil&quot;</span>","value":"\"GundalaNikhil\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:48Z&quot;</span>","value":"\"2020-06-19T02:25:48Z\""}],"value":"(1 \"12675650283\" \"GundalaNikhil/Vehicle-Detection\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"GundalaNikhil\" 2 \"2020-06-19T02:25:48Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;12675650288&quot;</span>","value":"\"12675650288\""},{"type":"html","content":"<span class='clj-string'>&quot;gmbzero/rancher-charts&quot;</span>","value":"\"gmbzero/rancher-charts\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;gmbzero&quot;</span>","value":"\"gmbzero\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:48Z&quot;</span>","value":"\"2020-06-19T02:25:48Z\""}],"value":"(2 \"12675650288\" \"gmbzero/rancher-charts\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"gmbzero\" 2 \"2020-06-19T02:25:48Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-string'>&quot;12675650294&quot;</span>","value":"\"12675650294\""},{"type":"html","content":"<span class='clj-string'>&quot;tinatian/liferay-portal&quot;</span>","value":"\"tinatian/liferay-portal\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;tinatian&quot;</span>","value":"\"tinatian\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:48Z&quot;</span>","value":"\"2020-06-19T02:25:48Z\""}],"value":"(3 \"12675650294\" \"tinatian/liferay-portal\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"tinatian\" 5 \"2020-06-19T02:25:48Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-string'>&quot;12675650303&quot;</span>","value":"\"12675650303\""},{"type":"html","content":"<span class='clj-string'>&quot;Scholz4208/Lab_Website_4&quot;</span>","value":"\"Scholz4208/Lab_Website_4\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Scholz4208&quot;</span>","value":"\"Scholz4208\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:48Z&quot;</span>","value":"\"2020-06-19T02:25:48Z\""}],"value":"(4 \"12675650303\" \"Scholz4208/Lab_Website_4\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Scholz4208\" 5 \"2020-06-19T02:25:48Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;12675650307&quot;</span>","value":"\"12675650307\""},{"type":"html","content":"<span class='clj-string'>&quot;kammanz/raptors-app&quot;</span>","value":"\"kammanz/raptors-app\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue)</span>","value":"(:action :issue)"},{"type":"html","content":"<span class='clj-string'>&quot;IssuesEvent&quot;</span>","value":"\"IssuesEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Tumne&quot;</span>","value":"\"Tumne\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:48Z&quot;</span>","value":"\"2020-06-19T02:25:48Z\""}],"value":"(5 \"12675650307\" \"kammanz/raptors-app\" (:action :issue) \"IssuesEvent\" \"Tumne\" 1 \"2020-06-19T02:25:48Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-string'>&quot;12675650314&quot;</span>","value":"\"12675650314\""},{"type":"html","content":"<span class='clj-string'>&quot;dsandilla91/cartoon-collections-onl01-seng-pt-061520&quot;</span>","value":"\"dsandilla91/cartoon-collections-onl01-seng-pt-061520\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;dsandilla91&quot;</span>","value":"\"dsandilla91\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:48Z&quot;</span>","value":"\"2020-06-19T02:25:48Z\""}],"value":"(6 \"12675650314\" \"dsandilla91/cartoon-collections-onl01-seng-pt-061520\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"dsandilla91\" 5 \"2020-06-19T02:25:48Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-string'>&quot;12675650315&quot;</span>","value":"\"12675650315\""},{"type":"html","content":"<span class='clj-string'>&quot;1980475806/github-slideshow&quot;</span>","value":"\"1980475806/github-slideshow\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;github-learning-lab[bot]&quot;</span>","value":"\"github-learning-lab[bot]\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:48Z&quot;</span>","value":"\"2020-06-19T02:25:48Z\""}],"value":"(7 \"12675650315\" \"1980475806/github-slideshow\" (:action :issue :comment) \"IssueCommentEvent\" \"github-learning-lab[bot]\" 1 \"2020-06-19T02:25:48Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-string'>&quot;12675650324&quot;</span>","value":"\"12675650324\""},{"type":"html","content":"<span class='clj-string'>&quot;learn-co-students/js-advanced-functions-functional-library-project-onl01-seng-ft-030220&quot;</span>","value":"\"learn-co-students/js-advanced-functions-functional-library-project-onl01-seng-ft-030220\""},{"type":"html","content":"<span class='clj-unkown'>(:forkee)</span>","value":"(:forkee)"},{"type":"html","content":"<span class='clj-string'>&quot;ForkEvent&quot;</span>","value":"\"ForkEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Beekasha&quot;</span>","value":"\"Beekasha\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:48Z&quot;</span>","value":"\"2020-06-19T02:25:48Z\""}],"value":"(8 \"12675650324\" \"learn-co-students/js-advanced-functions-functional-library-project-onl01-seng-ft-030220\" (:forkee) \"ForkEvent\" \"Beekasha\" 1 \"2020-06-19T02:25:48Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-string'>&quot;12675650336&quot;</span>","value":"\"12675650336\""},{"type":"html","content":"<span class='clj-string'>&quot;juangamio/sitioweb&quot;</span>","value":"\"juangamio/sitioweb\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;juangamio&quot;</span>","value":"\"juangamio\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:48Z&quot;</span>","value":"\"2020-06-19T02:25:48Z\""}],"value":"(9 \"12675650336\" \"juangamio/sitioweb\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"juangamio\" 5 \"2020-06-19T02:25:48Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-string'>&quot;12675650339&quot;</span>","value":"\"12675650339\""},{"type":"html","content":"<span class='clj-string'>&quot;kahlan/kahlan&quot;</span>","value":"\"kahlan/kahlan\""},{"type":"html","content":"<span class='clj-unkown'>(:action)</span>","value":"(:action)"},{"type":"html","content":"<span class='clj-string'>&quot;WatchEvent&quot;</span>","value":"\"WatchEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;weirdan&quot;</span>","value":"\"weirdan\""},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(10 \"12675650339\" \"kahlan/kahlan\" (:action) \"WatchEvent\" \"weirdan\" 3 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>11</span>","value":"11"},{"type":"html","content":"<span class='clj-string'>&quot;12675650350&quot;</span>","value":"\"12675650350\""},{"type":"html","content":"<span class='clj-string'>&quot;woocommerce/woocommerce-admin&quot;</span>","value":"\"woocommerce/woocommerce-admin\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;psealock&quot;</span>","value":"\"psealock\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(11 \"12675650350\" \"woocommerce/woocommerce-admin\" (:action :issue :comment) \"IssueCommentEvent\" \"psealock\" 1 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-string'>&quot;12675650356&quot;</span>","value":"\"12675650356\""},{"type":"html","content":"<span class='clj-string'>&quot;terraform-providers/terraform-provider-aws&quot;</span>","value":"\"terraform-providers/terraform-provider-aws\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;hashibot[bot]&quot;</span>","value":"\"hashibot[bot]\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(12 \"12675650356\" \"terraform-providers/terraform-provider-aws\" (:action :issue :comment) \"IssueCommentEvent\" \"hashibot[bot]\" 1 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>13</span>","value":"13"},{"type":"html","content":"<span class='clj-string'>&quot;12675650359&quot;</span>","value":"\"12675650359\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot/java-trace&quot;</span>","value":"\"renovate-bot/java-trace\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot&quot;</span>","value":"\"renovate-bot\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(13 \"12675650359\" \"renovate-bot/java-trace\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-string'>&quot;12675650363&quot;</span>","value":"\"12675650363\""},{"type":"html","content":"<span class='clj-string'>&quot;brucechin/SurviveSJTUManual&quot;</span>","value":"\"brucechin/SurviveSJTUManual\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;brucechin&quot;</span>","value":"\"brucechin\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(14 \"12675650363\" \"brucechin/SurviveSJTUManual\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"brucechin\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>15</span>","value":"15"},{"type":"html","content":"<span class='clj-string'>&quot;12675650365&quot;</span>","value":"\"12675650365\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot/java-datacatalog&quot;</span>","value":"\"renovate-bot/java-datacatalog\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot&quot;</span>","value":"\"renovate-bot\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(15 \"12675650365\" \"renovate-bot/java-datacatalog\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-string'>&quot;12675650367&quot;</span>","value":"\"12675650367\""},{"type":"html","content":"<span class='clj-string'>&quot;MichaelV159/js-es6-&quot;</span>","value":"\"MichaelV159/js-es6-\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;MichaelV159&quot;</span>","value":"\"MichaelV159\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(16 \"12675650367\" \"MichaelV159/js-es6-\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"MichaelV159\" 2 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>17</span>","value":"17"},{"type":"html","content":"<span class='clj-string'>&quot;12675650368&quot;</span>","value":"\"12675650368\""},{"type":"html","content":"<span class='clj-string'>&quot;2zz2xx2cc/online-education&quot;</span>","value":"\"2zz2xx2cc/online-education\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;2zz2xx2cc&quot;</span>","value":"\"2zz2xx2cc\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(17 \"12675650368\" \"2zz2xx2cc/online-education\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"2zz2xx2cc\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"},{"type":"html","content":"<span class='clj-string'>&quot;12675650372&quot;</span>","value":"\"12675650372\""},{"type":"html","content":"<span class='clj-string'>&quot;sorvani/freepbx-helper-scripts&quot;</span>","value":"\"sorvani/freepbx-helper-scripts\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;sorvani&quot;</span>","value":"\"sorvani\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(18 \"12675650372\" \"sorvani/freepbx-helper-scripts\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"sorvani\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>19</span>","value":"19"},{"type":"html","content":"<span class='clj-string'>&quot;12675650373&quot;</span>","value":"\"12675650373\""},{"type":"html","content":"<span class='clj-string'>&quot;davnavr/Classier&quot;</span>","value":"\"davnavr/Classier\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;davnavr&quot;</span>","value":"\"davnavr\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(19 \"12675650373\" \"davnavr/Classier\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"davnavr\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>20</span>","value":"20"},{"type":"html","content":"<span class='clj-string'>&quot;12675650378&quot;</span>","value":"\"12675650378\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot/java-compute&quot;</span>","value":"\"renovate-bot/java-compute\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot&quot;</span>","value":"\"renovate-bot\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(20 \"12675650378\" \"renovate-bot/java-compute\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>21</span>","value":"21"},{"type":"html","content":"<span class='clj-string'>&quot;12675650381&quot;</span>","value":"\"12675650381\""},{"type":"html","content":"<span class='clj-string'>&quot;dylanmcreynolds/splash-deploy&quot;</span>","value":"\"dylanmcreynolds/splash-deploy\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;dylanmcreynolds&quot;</span>","value":"\"dylanmcreynolds\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(21 \"12675650381\" \"dylanmcreynolds/splash-deploy\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"dylanmcreynolds\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>22</span>","value":"22"},{"type":"html","content":"<span class='clj-string'>&quot;12675650384&quot;</span>","value":"\"12675650384\""},{"type":"html","content":"<span class='clj-string'>&quot;mariazevedo88/airbnb-scraper&quot;</span>","value":"\"mariazevedo88/airbnb-scraper\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :pusher_type)</span>","value":"(:ref :ref_type :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;DeleteEvent&quot;</span>","value":"\"DeleteEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;mariazevedo88&quot;</span>","value":"\"mariazevedo88\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(22 \"12675650384\" \"mariazevedo88/airbnb-scraper\" (:ref :ref_type :pusher_type) \"DeleteEvent\" \"mariazevedo88\" 1 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>23</span>","value":"23"},{"type":"html","content":"<span class='clj-string'>&quot;12675650385&quot;</span>","value":"\"12675650385\""},{"type":"html","content":"<span class='clj-string'>&quot;vijay13101996/PIMD&quot;</span>","value":"\"vijay13101996/PIMD\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;vijay13101996&quot;</span>","value":"\"vijay13101996\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(23 \"12675650385\" \"vijay13101996/PIMD\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"vijay13101996\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>24</span>","value":"24"},{"type":"html","content":"<span class='clj-string'>&quot;12675650387&quot;</span>","value":"\"12675650387\""},{"type":"html","content":"<span class='clj-string'>&quot;jenkins-zh/jenkins-zh&quot;</span>","value":"\"jenkins-zh/jenkins-zh\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;wenjunzhangp&quot;</span>","value":"\"wenjunzhangp\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(24 \"12675650387\" \"jenkins-zh/jenkins-zh\" (:action :issue :comment) \"IssueCommentEvent\" \"wenjunzhangp\" 1 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>25</span>","value":"25"},{"type":"html","content":"<span class='clj-string'>&quot;12675650391&quot;</span>","value":"\"12675650391\""},{"type":"html","content":"<span class='clj-string'>&quot;OnikNoor97/lmaoo&quot;</span>","value":"\"OnikNoor97/lmaoo\""},{"type":"html","content":"<span class='clj-unkown'>(:action :number :pull_request)</span>","value":"(:action :number :pull_request)"},{"type":"html","content":"<span class='clj-string'>&quot;PullRequestEvent&quot;</span>","value":"\"PullRequestEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;LewisWelch94&quot;</span>","value":"\"LewisWelch94\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(25 \"12675650391\" \"OnikNoor97/lmaoo\" (:action :number :pull_request) \"PullRequestEvent\" \"LewisWelch94\" 1 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>26</span>","value":"26"},{"type":"html","content":"<span class='clj-string'>&quot;12675650395&quot;</span>","value":"\"12675650395\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot/python-datalabeling&quot;</span>","value":"\"renovate-bot/python-datalabeling\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot&quot;</span>","value":"\"renovate-bot\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(26 \"12675650395\" \"renovate-bot/python-datalabeling\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>27</span>","value":"27"},{"type":"html","content":"<span class='clj-string'>&quot;12675650402&quot;</span>","value":"\"12675650402\""},{"type":"html","content":"<span class='clj-string'>&quot;JadedPacks/Agrarian-Skies-2&quot;</span>","value":"\"JadedPacks/Agrarian-Skies-2\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;remclave&quot;</span>","value":"\"remclave\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(27 \"12675650402\" \"JadedPacks/Agrarian-Skies-2\" (:action :issue :comment) \"IssueCommentEvent\" \"remclave\" 1 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>28</span>","value":"28"},{"type":"html","content":"<span class='clj-string'>&quot;12675650404&quot;</span>","value":"\"12675650404\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot/python-logging&quot;</span>","value":"\"renovate-bot/python-logging\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;renovate-bot&quot;</span>","value":"\"renovate-bot\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(28 \"12675650404\" \"renovate-bot/python-logging\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>29</span>","value":"29"},{"type":"html","content":"<span class='clj-string'>&quot;12675650405&quot;</span>","value":"\"12675650405\""},{"type":"html","content":"<span class='clj-string'>&quot;omegaup/omegajail&quot;</span>","value":"\"omegaup/omegajail\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;github-actions[bot]&quot;</span>","value":"\"github-actions[bot]\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(29 \"12675650405\" \"omegaup/omegajail\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"github-actions[bot]\" 2 \"2020-06-19T02:25:49Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>30</span>","value":"30"},{"type":"html","content":"<span class='clj-string'>&quot;12675650410&quot;</span>","value":"\"12675650410\""},{"type":"html","content":"<span class='clj-string'>&quot;chrislvt/CG&quot;</span>","value":"\"chrislvt/CG\""},{"type":"html","content":"<span class='clj-unkown'>(:pages)</span>","value":"(:pages)"},{"type":"html","content":"<span class='clj-string'>&quot;GollumEvent&quot;</span>","value":"\"GollumEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;arinauntilova&quot;</span>","value":"\"arinauntilova\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T02:25:49Z&quot;</span>","value":"\"2020-06-19T02:25:49Z\""}],"value":"(30 \"12675650410\" \"chrislvt/CG\" (:pages) \"GollumEvent\" \"arinauntilova\" 1 \"2020-06-19T02:25:49Z\")"}],"value":"#gorilla_repl.table.TableView{:contents ((1 \"12675650283\" \"GundalaNikhil/Vehicle-Detection\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"GundalaNikhil\" 2 \"2020-06-19T02:25:48Z\") (2 \"12675650288\" \"gmbzero/rancher-charts\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"gmbzero\" 2 \"2020-06-19T02:25:48Z\") (3 \"12675650294\" \"tinatian/liferay-portal\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"tinatian\" 5 \"2020-06-19T02:25:48Z\") (4 \"12675650303\" \"Scholz4208/Lab_Website_4\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Scholz4208\" 5 \"2020-06-19T02:25:48Z\") (5 \"12675650307\" \"kammanz/raptors-app\" (:action :issue) \"IssuesEvent\" \"Tumne\" 1 \"2020-06-19T02:25:48Z\") (6 \"12675650314\" \"dsandilla91/cartoon-collections-onl01-seng-pt-061520\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"dsandilla91\" 5 \"2020-06-19T02:25:48Z\") (7 \"12675650315\" \"1980475806/github-slideshow\" (:action :issue :comment) \"IssueCommentEvent\" \"github-learning-lab[bot]\" 1 \"2020-06-19T02:25:48Z\") (8 \"12675650324\" \"learn-co-students/js-advanced-functions-functional-library-project-onl01-seng-ft-030220\" (:forkee) \"ForkEvent\" \"Beekasha\" 1 \"2020-06-19T02:25:48Z\") (9 \"12675650336\" \"juangamio/sitioweb\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"juangamio\" 5 \"2020-06-19T02:25:48Z\") (10 \"12675650339\" \"kahlan/kahlan\" (:action) \"WatchEvent\" \"weirdan\" 3 \"2020-06-19T02:25:49Z\") (11 \"12675650350\" \"woocommerce/woocommerce-admin\" (:action :issue :comment) \"IssueCommentEvent\" \"psealock\" 1 \"2020-06-19T02:25:49Z\") (12 \"12675650356\" \"terraform-providers/terraform-provider-aws\" (:action :issue :comment) \"IssueCommentEvent\" \"hashibot[bot]\" 1 \"2020-06-19T02:25:49Z\") (13 \"12675650359\" \"renovate-bot/java-trace\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\") (14 \"12675650363\" \"brucechin/SurviveSJTUManual\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"brucechin\" 5 \"2020-06-19T02:25:49Z\") (15 \"12675650365\" \"renovate-bot/java-datacatalog\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\") (16 \"12675650367\" \"MichaelV159/js-es6-\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"MichaelV159\" 2 \"2020-06-19T02:25:49Z\") (17 \"12675650368\" \"2zz2xx2cc/online-education\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"2zz2xx2cc\" 5 \"2020-06-19T02:25:49Z\") (18 \"12675650372\" \"sorvani/freepbx-helper-scripts\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"sorvani\" 5 \"2020-06-19T02:25:49Z\") (19 \"12675650373\" \"davnavr/Classier\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"davnavr\" 5 \"2020-06-19T02:25:49Z\") (20 \"12675650378\" \"renovate-bot/java-compute\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\") (21 \"12675650381\" \"dylanmcreynolds/splash-deploy\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"dylanmcreynolds\" 5 \"2020-06-19T02:25:49Z\") (22 \"12675650384\" \"mariazevedo88/airbnb-scraper\" (:ref :ref_type :pusher_type) \"DeleteEvent\" \"mariazevedo88\" 1 \"2020-06-19T02:25:49Z\") (23 \"12675650385\" \"vijay13101996/PIMD\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"vijay13101996\" 5 \"2020-06-19T02:25:49Z\") (24 \"12675650387\" \"jenkins-zh/jenkins-zh\" (:action :issue :comment) \"IssueCommentEvent\" \"wenjunzhangp\" 1 \"2020-06-19T02:25:49Z\") (25 \"12675650391\" \"OnikNoor97/lmaoo\" (:action :number :pull_request) \"PullRequestEvent\" \"LewisWelch94\" 1 \"2020-06-19T02:25:49Z\") (26 \"12675650395\" \"renovate-bot/python-datalabeling\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\") (27 \"12675650402\" \"JadedPacks/Agrarian-Skies-2\" (:action :issue :comment) \"IssueCommentEvent\" \"remclave\" 1 \"2020-06-19T02:25:49Z\") (28 \"12675650404\" \"renovate-bot/python-logging\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"renovate-bot\" 5 \"2020-06-19T02:25:49Z\") (29 \"12675650405\" \"omegaup/omegajail\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"github-actions[bot]\" 2 \"2020-06-19T02:25:49Z\") (30 \"12675650410\" \"chrislvt/CG\" (:pages) \"GollumEvent\" \"arinauntilova\" 1 \"2020-06-19T02:25:49Z\")), :opts nil}"}
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
