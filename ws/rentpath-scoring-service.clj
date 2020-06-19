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
;;; {"type":"list-like","open":"<center><table>","close":"</table></center>","separator":"\n","items":[{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;12674955362&quot;</span>","value":"\"12674955362\""},{"type":"html","content":"<span class='clj-string'>&quot;philihp/score&quot;</span>","value":"\"philihp/score\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;philihp&quot;</span>","value":"\"philihp\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(1 \"12674955362\" \"philihp/score\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"philihp\" 5 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;12674955369&quot;</span>","value":"\"12674955369\""},{"type":"html","content":"<span class='clj-string'>&quot;swedishtechevents/swedishtechevents.github.io&quot;</span>","value":"\"swedishtechevents/swedishtechevents.github.io\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;frozzbot&quot;</span>","value":"\"frozzbot\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(2 \"12674955369\" \"swedishtechevents/swedishtechevents.github.io\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"frozzbot\" 5 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-string'>&quot;12674955374&quot;</span>","value":"\"12674955374\""},{"type":"html","content":"<span class='clj-string'>&quot;dotnet/roslyn&quot;</span>","value":"\"dotnet/roslyn\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :pusher_type)</span>","value":"(:ref :ref_type :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;DeleteEvent&quot;</span>","value":"\"DeleteEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;dotnet-bot&quot;</span>","value":"\"dotnet-bot\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(3 \"12674955374\" \"dotnet/roslyn\" (:ref :ref_type :pusher_type) \"DeleteEvent\" \"dotnet-bot\" 1 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-string'>&quot;12674955382&quot;</span>","value":"\"12674955382\""},{"type":"html","content":"<span class='clj-string'>&quot;Ar0xA/worldchatlog&quot;</span>","value":"\"Ar0xA/worldchatlog\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Ar0xA&quot;</span>","value":"\"Ar0xA\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(4 \"12674955382\" \"Ar0xA/worldchatlog\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Ar0xA\" 5 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;12674955387&quot;</span>","value":"\"12674955387\""},{"type":"html","content":"<span class='clj-string'>&quot;BlackListed0/dync&quot;</span>","value":"\"BlackListed0/dync\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;BlackListed0&quot;</span>","value":"\"BlackListed0\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(5 \"12674955387\" \"BlackListed0/dync\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"BlackListed0\" 5 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-string'>&quot;12674955389&quot;</span>","value":"\"12674955389\""},{"type":"html","content":"<span class='clj-string'>&quot;jackfrued/Python-100-Days&quot;</span>","value":"\"jackfrued/Python-100-Days\""},{"type":"html","content":"<span class='clj-unkown'>(:forkee)</span>","value":"(:forkee)"},{"type":"html","content":"<span class='clj-string'>&quot;ForkEvent&quot;</span>","value":"\"ForkEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;268152125115&quot;</span>","value":"\"268152125115\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(6 \"12674955389\" \"jackfrued/Python-100-Days\" (:forkee) \"ForkEvent\" \"268152125115\" 1 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-string'>&quot;12674955391&quot;</span>","value":"\"12674955391\""},{"type":"html","content":"<span class='clj-string'>&quot;brand22/d3&quot;</span>","value":"\"brand22/d3\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Hall-1910&quot;</span>","value":"\"Hall-1910\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(7 \"12674955391\" \"brand22/d3\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Hall-1910\" 5 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-string'>&quot;12674955394&quot;</span>","value":"\"12674955394\""},{"type":"html","content":"<span class='clj-string'>&quot;ProcursusTeam/repo&quot;</span>","value":"\"ProcursusTeam/repo\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Diatrus&quot;</span>","value":"\"Diatrus\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(8 \"12674955394\" \"ProcursusTeam/repo\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Diatrus\" 5 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-string'>&quot;12674955396&quot;</span>","value":"\"12674955396\""},{"type":"html","content":"<span class='clj-string'>&quot;FasterXML/jackson-modules-base&quot;</span>","value":"\"FasterXML/jackson-modules-base\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;cowtowncoder&quot;</span>","value":"\"cowtowncoder\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(9 \"12674955396\" \"FasterXML/jackson-modules-base\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"cowtowncoder\" 5 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-string'>&quot;12674955398&quot;</span>","value":"\"12674955398\""},{"type":"html","content":"<span class='clj-string'>&quot;tonitdiep/activerecord-tvland-onl01-seng-ft-050420&quot;</span>","value":"\"tonitdiep/activerecord-tvland-onl01-seng-ft-050420\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;tonitdiep&quot;</span>","value":"\"tonitdiep\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(10 \"12674955398\" \"tonitdiep/activerecord-tvland-onl01-seng-ft-050420\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"tonitdiep\" 5 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>11</span>","value":"11"},{"type":"html","content":"<span class='clj-string'>&quot;12674955400&quot;</span>","value":"\"12674955400\""},{"type":"html","content":"<span class='clj-string'>&quot;RhysonEden/linkenator&quot;</span>","value":"\"RhysonEden/linkenator\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;RhysonEden&quot;</span>","value":"\"RhysonEden\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(11 \"12674955400\" \"RhysonEden/linkenator\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"RhysonEden\" 2 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-string'>&quot;12674955403&quot;</span>","value":"\"12674955403\""},{"type":"html","content":"<span class='clj-string'>&quot;NREL/openstudio-standards&quot;</span>","value":"\"NREL/openstudio-standards\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;lymereJ&quot;</span>","value":"\"lymereJ\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(12 \"12674955403\" \"NREL/openstudio-standards\" (:action :issue :comment) \"IssueCommentEvent\" \"lymereJ\" 1 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>13</span>","value":"13"},{"type":"html","content":"<span class='clj-string'>&quot;12674955407&quot;</span>","value":"\"12674955407\""},{"type":"html","content":"<span class='clj-string'>&quot;pop-os/shell&quot;</span>","value":"\"pop-os/shell\""},{"type":"html","content":"<span class='clj-unkown'>(:action)</span>","value":"(:action)"},{"type":"html","content":"<span class='clj-string'>&quot;WatchEvent&quot;</span>","value":"\"WatchEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;tadan0&quot;</span>","value":"\"tadan0\""},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:43Z&quot;</span>","value":"\"2020-06-19T00:01:43Z\""}],"value":"(13 \"12674955407\" \"pop-os/shell\" (:action) \"WatchEvent\" \"tadan0\" 3 \"2020-06-19T00:01:43Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-string'>&quot;12674955410&quot;</span>","value":"\"12674955410\""},{"type":"html","content":"<span class='clj-string'>&quot;Anlander/gatsby&quot;</span>","value":"\"Anlander/gatsby\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Anlander&quot;</span>","value":"\"Anlander\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(14 \"12674955410\" \"Anlander/gatsby\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Anlander\" 5 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>15</span>","value":"15"},{"type":"html","content":"<span class='clj-string'>&quot;12674955412&quot;</span>","value":"\"12674955412\""},{"type":"html","content":"<span class='clj-string'>&quot;tak-shimizu10/touring_note_my&quot;</span>","value":"\"tak-shimizu10/touring_note_my\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;tak-shimizu10&quot;</span>","value":"\"tak-shimizu10\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(15 \"12674955412\" \"tak-shimizu10/touring_note_my\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"tak-shimizu10\" 2 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-string'>&quot;12674955415&quot;</span>","value":"\"12674955415\""},{"type":"html","content":"<span class='clj-string'>&quot;lisael/fastidious&quot;</span>","value":"\"lisael/fastidious\""},{"type":"html","content":"<span class='clj-unkown'>(:action :number :pull_request)</span>","value":"(:action :number :pull_request)"},{"type":"html","content":"<span class='clj-string'>&quot;PullRequestEvent&quot;</span>","value":"\"PullRequestEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;lisael&quot;</span>","value":"\"lisael\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(16 \"12674955415\" \"lisael/fastidious\" (:action :number :pull_request) \"PullRequestEvent\" \"lisael\" 1 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>17</span>","value":"17"},{"type":"html","content":"<span class='clj-string'>&quot;12674955425&quot;</span>","value":"\"12674955425\""},{"type":"html","content":"<span class='clj-string'>&quot;BlackMooth/Random-Graphs&quot;</span>","value":"\"BlackMooth/Random-Graphs\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;BlackMooth&quot;</span>","value":"\"BlackMooth\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(17 \"12674955425\" \"BlackMooth/Random-Graphs\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"BlackMooth\" 5 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"},{"type":"html","content":"<span class='clj-string'>&quot;12674955431&quot;</span>","value":"\"12674955431\""},{"type":"html","content":"<span class='clj-string'>&quot;openshift/origin&quot;</span>","value":"\"openshift/origin\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;openshift-ci-robot&quot;</span>","value":"\"openshift-ci-robot\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(18 \"12674955431\" \"openshift/origin\" (:action :issue :comment) \"IssueCommentEvent\" \"openshift-ci-robot\" 1 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>19</span>","value":"19"},{"type":"html","content":"<span class='clj-string'>&quot;12674955435&quot;</span>","value":"\"12674955435\""},{"type":"html","content":"<span class='clj-string'>&quot;ltramos7/learn-co-sandbox&quot;</span>","value":"\"ltramos7/learn-co-sandbox\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;ltramos7&quot;</span>","value":"\"ltramos7\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(19 \"12674955435\" \"ltramos7/learn-co-sandbox\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"ltramos7\" 5 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>20</span>","value":"20"},{"type":"html","content":"<span class='clj-string'>&quot;12674955439&quot;</span>","value":"\"12674955439\""},{"type":"html","content":"<span class='clj-string'>&quot;saby/router&quot;</span>","value":"\"saby/router\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;SiarheiSakharevich&quot;</span>","value":"\"SiarheiSakharevich\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(20 \"12674955439\" \"saby/router\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"SiarheiSakharevich\" 2 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>21</span>","value":"21"},{"type":"html","content":"<span class='clj-string'>&quot;12674955441&quot;</span>","value":"\"12674955441\""},{"type":"html","content":"<span class='clj-string'>&quot;Ziah-M/Movie-Site&quot;</span>","value":"\"Ziah-M/Movie-Site\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;Ziah-M&quot;</span>","value":"\"Ziah-M\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(21 \"12674955441\" \"Ziah-M/Movie-Site\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Ziah-M\" 5 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>22</span>","value":"22"},{"type":"html","content":"<span class='clj-string'>&quot;12674955442&quot;</span>","value":"\"12674955442\""},{"type":"html","content":"<span class='clj-string'>&quot;raublekick/phx-covid-businesses&quot;</span>","value":"\"raublekick/phx-covid-businesses\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;raublekick&quot;</span>","value":"\"raublekick\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(22 \"12674955442\" \"raublekick/phx-covid-businesses\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"raublekick\" 5 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>23</span>","value":"23"},{"type":"html","content":"<span class='clj-string'>&quot;12674955443&quot;</span>","value":"\"12674955443\""},{"type":"html","content":"<span class='clj-string'>&quot;MakzaR/oop-gui&quot;</span>","value":"\"MakzaR/oop-gui\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;MakzaR&quot;</span>","value":"\"MakzaR\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(23 \"12674955443\" \"MakzaR/oop-gui\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"MakzaR\" 5 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>24</span>","value":"24"},{"type":"html","content":"<span class='clj-string'>&quot;12674955444&quot;</span>","value":"\"12674955444\""},{"type":"html","content":"<span class='clj-string'>&quot;marklchaves/will-work-for-ko-fi&quot;</span>","value":"\"marklchaves/will-work-for-ko-fi\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;marklchaves&quot;</span>","value":"\"marklchaves\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(24 \"12674955444\" \"marklchaves/will-work-for-ko-fi\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"marklchaves\" 5 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>25</span>","value":"25"},{"type":"html","content":"<span class='clj-string'>&quot;12674955445&quot;</span>","value":"\"12674955445\""},{"type":"html","content":"<span class='clj-string'>&quot;firtod0dev/bot-auto-upload-shellz&quot;</span>","value":"\"firtod0dev/bot-auto-upload-shellz\""},{"type":"html","content":"<span class='clj-unkown'>(:ref :ref_type :master_branch :description :pusher_type)</span>","value":"(:ref :ref_type :master_branch :description :pusher_type)"},{"type":"html","content":"<span class='clj-string'>&quot;CreateEvent&quot;</span>","value":"\"CreateEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;firtod0dev&quot;</span>","value":"\"firtod0dev\""},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(25 \"12674955445\" \"firtod0dev/bot-auto-upload-shellz\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"firtod0dev\" 2 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>26</span>","value":"26"},{"type":"html","content":"<span class='clj-string'>&quot;12674955446&quot;</span>","value":"\"12674955446\""},{"type":"html","content":"<span class='clj-string'>&quot;hi09812300/test&quot;</span>","value":"\"hi09812300/test\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;hi09812300&quot;</span>","value":"\"hi09812300\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(26 \"12674955446\" \"hi09812300/test\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"hi09812300\" 5 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>27</span>","value":"27"},{"type":"html","content":"<span class='clj-string'>&quot;12674955450&quot;</span>","value":"\"12674955450\""},{"type":"html","content":"<span class='clj-string'>&quot;j-hernandez/counter-redux&quot;</span>","value":"\"j-hernandez/counter-redux\""},{"type":"html","content":"<span class='clj-unkown'>(:forkee)</span>","value":"(:forkee)"},{"type":"html","content":"<span class='clj-string'>&quot;ForkEvent&quot;</span>","value":"\"ForkEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;21ahegde&quot;</span>","value":"\"21ahegde\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(27 \"12674955450\" \"j-hernandez/counter-redux\" (:forkee) \"ForkEvent\" \"21ahegde\" 1 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>28</span>","value":"28"},{"type":"html","content":"<span class='clj-string'>&quot;12674955459&quot;</span>","value":"\"12674955459\""},{"type":"html","content":"<span class='clj-string'>&quot;target/lorri&quot;</span>","value":"\"target/lorri\""},{"type":"html","content":"<span class='clj-unkown'>(:action :issue :comment)</span>","value":"(:action :issue :comment)"},{"type":"html","content":"<span class='clj-string'>&quot;IssueCommentEvent&quot;</span>","value":"\"IssueCommentEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;codygman&quot;</span>","value":"\"codygman\""},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(28 \"12674955459\" \"target/lorri\" (:action :issue :comment) \"IssueCommentEvent\" \"codygman\" 1 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>29</span>","value":"29"},{"type":"html","content":"<span class='clj-string'>&quot;12674955460&quot;</span>","value":"\"12674955460\""},{"type":"html","content":"<span class='clj-string'>&quot;ax3l/spacebot-test&quot;</span>","value":"\"ax3l/spacebot-test\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;ax3l&quot;</span>","value":"\"ax3l\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(29 \"12674955460\" \"ax3l/spacebot-test\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"ax3l\" 5 \"2020-06-19T00:01:44Z\")"},{"type":"list-like","open":"<tr><td>","close":"</td></tr>","separator":"</td><td>","items":[{"type":"html","content":"<span class='clj-long'>30</span>","value":"30"},{"type":"html","content":"<span class='clj-string'>&quot;12674955469&quot;</span>","value":"\"12674955469\""},{"type":"html","content":"<span class='clj-string'>&quot;tanzmehr/nearest-neighbors-lab-data-science-intro-000&quot;</span>","value":"\"tanzmehr/nearest-neighbors-lab-data-science-intro-000\""},{"type":"html","content":"<span class='clj-unkown'>(:push_id :size :distinct_size :ref :head :before :commits)</span>","value":"(:push_id :size :distinct_size :ref :head :before :commits)"},{"type":"html","content":"<span class='clj-string'>&quot;PushEvent&quot;</span>","value":"\"PushEvent\""},{"type":"html","content":"<span class='clj-string'>&quot;tanzmehr&quot;</span>","value":"\"tanzmehr\""},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-string'>&quot;2020-06-19T00:01:44Z&quot;</span>","value":"\"2020-06-19T00:01:44Z\""}],"value":"(30 \"12674955469\" \"tanzmehr/nearest-neighbors-lab-data-science-intro-000\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"tanzmehr\" 5 \"2020-06-19T00:01:44Z\")"}],"value":"#gorilla_repl.table.TableView{:contents ((1 \"12674955362\" \"philihp/score\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"philihp\" 5 \"2020-06-19T00:01:43Z\") (2 \"12674955369\" \"swedishtechevents/swedishtechevents.github.io\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"frozzbot\" 5 \"2020-06-19T00:01:43Z\") (3 \"12674955374\" \"dotnet/roslyn\" (:ref :ref_type :pusher_type) \"DeleteEvent\" \"dotnet-bot\" 1 \"2020-06-19T00:01:43Z\") (4 \"12674955382\" \"Ar0xA/worldchatlog\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Ar0xA\" 5 \"2020-06-19T00:01:43Z\") (5 \"12674955387\" \"BlackListed0/dync\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"BlackListed0\" 5 \"2020-06-19T00:01:43Z\") (6 \"12674955389\" \"jackfrued/Python-100-Days\" (:forkee) \"ForkEvent\" \"268152125115\" 1 \"2020-06-19T00:01:43Z\") (7 \"12674955391\" \"brand22/d3\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Hall-1910\" 5 \"2020-06-19T00:01:43Z\") (8 \"12674955394\" \"ProcursusTeam/repo\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Diatrus\" 5 \"2020-06-19T00:01:43Z\") (9 \"12674955396\" \"FasterXML/jackson-modules-base\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"cowtowncoder\" 5 \"2020-06-19T00:01:43Z\") (10 \"12674955398\" \"tonitdiep/activerecord-tvland-onl01-seng-ft-050420\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"tonitdiep\" 5 \"2020-06-19T00:01:43Z\") (11 \"12674955400\" \"RhysonEden/linkenator\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"RhysonEden\" 2 \"2020-06-19T00:01:43Z\") (12 \"12674955403\" \"NREL/openstudio-standards\" (:action :issue :comment) \"IssueCommentEvent\" \"lymereJ\" 1 \"2020-06-19T00:01:43Z\") (13 \"12674955407\" \"pop-os/shell\" (:action) \"WatchEvent\" \"tadan0\" 3 \"2020-06-19T00:01:43Z\") (14 \"12674955410\" \"Anlander/gatsby\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Anlander\" 5 \"2020-06-19T00:01:44Z\") (15 \"12674955412\" \"tak-shimizu10/touring_note_my\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"tak-shimizu10\" 2 \"2020-06-19T00:01:44Z\") (16 \"12674955415\" \"lisael/fastidious\" (:action :number :pull_request) \"PullRequestEvent\" \"lisael\" 1 \"2020-06-19T00:01:44Z\") (17 \"12674955425\" \"BlackMooth/Random-Graphs\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"BlackMooth\" 5 \"2020-06-19T00:01:44Z\") (18 \"12674955431\" \"openshift/origin\" (:action :issue :comment) \"IssueCommentEvent\" \"openshift-ci-robot\" 1 \"2020-06-19T00:01:44Z\") (19 \"12674955435\" \"ltramos7/learn-co-sandbox\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"ltramos7\" 5 \"2020-06-19T00:01:44Z\") (20 \"12674955439\" \"saby/router\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"SiarheiSakharevich\" 2 \"2020-06-19T00:01:44Z\") (21 \"12674955441\" \"Ziah-M/Movie-Site\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"Ziah-M\" 5 \"2020-06-19T00:01:44Z\") (22 \"12674955442\" \"raublekick/phx-covid-businesses\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"raublekick\" 5 \"2020-06-19T00:01:44Z\") (23 \"12674955443\" \"MakzaR/oop-gui\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"MakzaR\" 5 \"2020-06-19T00:01:44Z\") (24 \"12674955444\" \"marklchaves/will-work-for-ko-fi\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"marklchaves\" 5 \"2020-06-19T00:01:44Z\") (25 \"12674955445\" \"firtod0dev/bot-auto-upload-shellz\" (:ref :ref_type :master_branch :description :pusher_type) \"CreateEvent\" \"firtod0dev\" 2 \"2020-06-19T00:01:44Z\") (26 \"12674955446\" \"hi09812300/test\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"hi09812300\" 5 \"2020-06-19T00:01:44Z\") (27 \"12674955450\" \"j-hernandez/counter-redux\" (:forkee) \"ForkEvent\" \"21ahegde\" 1 \"2020-06-19T00:01:44Z\") (28 \"12674955459\" \"target/lorri\" (:action :issue :comment) \"IssueCommentEvent\" \"codygman\" 1 \"2020-06-19T00:01:44Z\") (29 \"12674955460\" \"ax3l/spacebot-test\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"ax3l\" 5 \"2020-06-19T00:01:44Z\") (30 \"12674955469\" \"tanzmehr/nearest-neighbors-lab-data-science-intro-000\" (:push_id :size :distinct_size :ref :head :before :commits) \"PushEvent\" \"tanzmehr\" 5 \"2020-06-19T00:01:44Z\")), :opts nil}"}
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
