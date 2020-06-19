;; gorilla-repl.fileformat = 1

;; **
;;; # Central limit theorem
;;; 
;;; We're going to look at the CLT in this worksheet, and simulate its action. Be reminded that
;;; 
;;; $$ \sum_i u_i \overset{d}\to N $$
;;; 
;;; where @@u_i@@ is a uniformly distributed random variable.
;; **

;; @@
(ns central-limit
  (:use gorilla-plot.core)
  (:use gorilla-test.core)
  (:use clojure.repl)
  (:use clojure.pprint))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn r [] (- (apply + (repeatedly 50 rand)) 25))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;central-limit/r</span>","value":"#'central-limit/r"}
;; <=

;; @@
(def data (repeatedly 1000 r))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;central-limit/data</span>","value":"#'central-limit/data"}
;; <=

;; **
;;; Let's compare the simulated data and the expected distribution.
;; **

;; @@
(compose
 (histogram data :bins 50 :normalise :probability-density)
 (plot #(gaussian % 2 0) [-10 10]))
;; @@
;; =>
;;; {"type":"vega","content":{"width":400,"height":247.2187957763672,"padding":{"top":10,"left":55,"bottom":40,"right":10},"scales":[{"name":"x","type":"linear","range":"width","zero":false,"domain":{"data":"8a174100-d128-44ee-9473-f1373d6619d6","field":"data.x"}},{"name":"y","type":"linear","range":"height","nice":true,"zero":false,"domain":{"data":"8a174100-d128-44ee-9473-f1373d6619d6","field":"data.y"}}],"axes":[{"type":"x","scale":"x"},{"type":"y","scale":"y"}],"data":[{"name":"8a174100-d128-44ee-9473-f1373d6619d6","values":[{"x":-5.570597904962771,"y":0},{"x":-5.31616886471027,"y":0.00786073790167646},{"x":-5.061739824457769,"y":0.0},{"x":-4.807310784205268,"y":0.00393036895083823},{"x":-4.552881743952767,"y":0.01572147580335292},{"x":-4.298452703700266,"y":0.01572147580335292},{"x":-4.044023663447765,"y":0.019651844754191152},{"x":-3.7895946231952644,"y":0.019651844754191152},{"x":-3.5351655829427635,"y":0.04323405845922053},{"x":-3.2807365426902626,"y":0.04323405845922053},{"x":-3.0263075024377617,"y":0.06288590321341168},{"x":-2.771878462185261,"y":0.09432885482011752},{"x":-2.51744942193276,"y":0.09432885482011752},{"x":-2.263020381680259,"y":0.10218959272179398},{"x":-2.008591341427758,"y":0.08646811691844106},{"x":-1.7541623011752572,"y":0.10218959272179398},{"x":-1.4997332609227563,"y":0.1847273406893968},{"x":-1.2453042206702554,"y":0.16114512698436745},{"x":-0.9908751804177545,"y":0.17293623383688211},{"x":-0.7364461401652536,"y":0.17293623383688211},{"x":-0.4820170999127526,"y":0.2083095543944262},{"x":-0.22758805966025164,"y":0.20044881649274973},{"x":0.02684098059224932,"y":0.21617029229610266},{"x":0.2812700208447503,"y":0.18079697173855858},{"x":0.5356990610972512,"y":0.17293623383688211},{"x":0.7901281013497521,"y":0.2083095543944262},{"x":1.044557141602253,"y":0.20044881649274973},{"x":1.298986181854754,"y":0.11005033062347044},{"x":1.5534152221072548,"y":0.15721475803352922},{"x":1.8078442623597557,"y":0.11398069957430867},{"x":2.062273302612257,"y":0.1297021753776616},{"x":2.3167023428647577,"y":0.10611996167263221},{"x":2.5711313831172586,"y":0.10611996167263221},{"x":2.8255604233697595,"y":0.07467701006592638},{"x":3.0799894636222604,"y":0.06288590321341168},{"x":3.3344185038747614,"y":0.07074664111508815},{"x":3.5888475441272623,"y":0.039303689508382304},{"x":3.843276584379763,"y":0.039303689508382304},{"x":4.0977056246322645,"y":0.05502516531173522},{"x":4.352134664884765,"y":0.01179110685251469},{"x":4.606563705137266,"y":0.019651844754191152},{"x":4.860992745389767,"y":0.02358221370502938},{"x":5.115421785642268,"y":0.00393036895083823},{"x":5.369850825894769,"y":0.00393036895083823},{"x":5.62427986614727,"y":0.00786073790167646},{"x":5.878708906399771,"y":0.0},{"x":6.133137946652272,"y":0.0},{"x":6.387566986904773,"y":0.0},{"x":6.6419960271572736,"y":0.0},{"x":6.8964250674097745,"y":0.0},{"x":7.150854107662275,"y":0.0},{"x":7.405283147914776,"y":0.00393036895083823},{"x":7.659712188167277,"y":0}]},{"name":"e3db35ce-b7f4-4bfa-8c73-24a93ec3afc4","values":[{"x":-10,"y":7.453306344157342E-7},{"x":-9.799999997019768,"y":1.2227136022020082E-6},{"x":-9.599999994039536,"y":1.9859008895787535E-6},{"x":-9.399999991059303,"y":3.1933568466554097E-6},{"x":-9.199999988079071,"y":5.083869442630077E-6},{"x":-8.999999985098839,"y":8.013059747248974E-6},{"x":-8.799999982118607,"y":1.2504301246871565E-5},{"x":-8.599999979138374,"y":1.9318683610927946E-5},{"x":-8.399999976158142,"y":2.9549673525896843E-5},{"x":-8.19999997317791,"y":4.474916120466938E-5},{"x":-7.999999970197678,"y":6.709252957952864E-5},{"x":-7.799999967217445,"y":9.959109066711276E-5},{"x":-7.599999964237213,"y":1.463604937211866E-4},{"x":-7.399999961256981,"y":2.129532625969202E-4},{"x":-7.199999958276749,"y":3.0676215890329826E-4},{"x":-6.999999955296516,"y":4.3749825786254407E-4},{"x":-6.799999952316284,"y":6.177431317230414E-4},{"x":-6.599999949336052,"y":8.635680737170301E-4},{"x":-6.39999994635582,"y":0.0011952046815864247},{"x":-6.1999999433755875,"y":0.0016377403466157404},{"x":-5.999999940395355,"y":0.002221799506292808},{"x":-5.799999937415123,"y":0.002984157484620092},{"x":-5.599999934434891,"y":0.003968219313121465},{"x":-5.3999999314546585,"y":0.005224282454218924},{"x":-5.199999928474426,"y":0.006809491580088464},{"x":-4.999999925494194,"y":0.008787387543070678},{"x":-4.799999922513962,"y":0.011226953610745277},{"x":-4.5999999195337296,"y":0.014201072062040727},{"x":-4.399999916553497,"y":0.017784325124320887},{"x":-4.199999913573265,"y":0.022050107061901632},{"x":-3.999999910593033,"y":0.027067059067306068},{"x":-3.7999999076128006,"y":0.032894894202544614},{"x":-3.5999999046325684,"y":0.03957974321387936},{"x":-3.399999901652336,"y":0.04714921925263572},{"x":-3.199999898672104,"y":0.0556074645983085},{"x":-2.9999998956918716,"y":0.06493049855125375},{"x":-2.7999998927116394,"y":0.07506222540759178},{"x":-2.599999889731407,"y":0.08591147779981703},{"x":-2.399999886751175,"y":0.09735045780688895},{"x":-2.1999998837709427,"y":0.10921489230961066},{"x":-1.9999998807907104,"y":0.12130613917293559},{"x":-1.7999998778104782,"y":0.13339536950647682},{"x":-1.599999874830246,"y":0.1452298146860898},{"x":-1.3999998718500137,"y":0.1565409146696238},{"x":-1.1999998688697815,"y":0.1670540488540041},{"x":-0.9999998658895493,"y":0.17649938643452168},{"x":-0.799999862909317,"y":0.18462327433935283},{"x":-0.5999998599290848,"y":0.1911995003838428},{"x":-0.39999985694885254,"y":0.19603973746572148},{"x":-0.1999998539686203,"y":0.19900249729156638},{"x":1.4901161193847656E-7,"y":0.19999999999999946},{"x":0.20000015199184418,"y":0.1990024943261981},{"x":0.4000001549720764,"y":0.19603973162328203},{"x":0.6000001579523087,"y":0.19119949183655915},{"x":0.8000001609325409,"y":0.1846232633349483},{"x":1.0000001639127731,"y":0.1764993732842929},{"x":1.2000001668930054,"y":0.1670540339182087},{"x":1.4000001698732376,"y":0.15654089834113458},{"x":1.6000001728534698,"y":0.14522979737334754},{"x":1.800000175833702,"y":0.1333953516167646},{"x":2.0000001788139343,"y":0.12130612109691333},{"x":2.2000001817941666,"y":0.109214874407896},{"x":2.400000184774399,"y":0.09735044039927186},{"x":2.600000187754631,"y":0.08591146115746827},{"x":2.8000001907348633,"y":0.07506220974839269},{"x":3.0000001937150955,"y":0.06493048403815777},{"x":3.2000001966953278,"y":0.055607451340457185},{"x":3.40000019967556,"y":0.04714920730880908},{"x":3.6000002026557922,"y":0.03957973259776622},{"x":3.8000002056360245,"y":0.03289488488927549},{"x":4.000000208616257,"y":0.02706705100069495},{"x":4.200000211596489,"y":0.02205010016188641},{"x":4.400000214576721,"y":0.017784319294165653},{"x":4.600000217556953,"y":0.014201067194954814},{"x":4.800000220537186,"y":0.011226949595674444},{"x":5.000000223517418,"y":0.008787384269514283},{"x":5.20000022649765,"y":0.006809488941886312},{"x":5.400000229477882,"y":0.0052242803523266925},{"x":5.600000232458115,"y":0.003968217657451668},{"x":5.800000235438347,"y":0.002984156195065413},{"x":6.000000238418579,"y":0.0022217985130712366},{"x":6.200000241398811,"y":0.001637739590084685},{"x":6.400000244379044,"y":0.0011952041116685484},{"x":6.600000247359276,"y":8.635676490676143E-4},{"x":6.800000250339508,"y":6.177428187500568E-4},{"x":7.00000025331974,"y":4.3749802968947785E-4},{"x":7.2000002562999725,"y":3.0676199434329435E-4},{"x":7.400000259280205,"y":2.1295314518666783E-4},{"x":7.600000262260437,"y":1.46360410845439E-4},{"x":7.800000265240669,"y":9.959103279023577E-5},{"x":8.000000268220901,"y":6.709248958927605E-5},{"x":8.200000271201134,"y":4.47491338652843E-5},{"x":8.400000274181366,"y":2.9549655032275533E-5},{"x":8.600000277161598,"y":1.9318671232486508E-5},{"x":8.80000028014183,"y":1.2504293048415349E-5},{"x":9.000000283122063,"y":8.013054374075417E-6},{"x":9.200000286102295,"y":5.083865957875547E-6},{"x":9.400000289082527,"y":3.193354610174078E-6},{"x":9.60000029206276,"y":1.9858994691522355E-6},{"x":9.800000295042992,"y":1.2227127094295497E-6}]}],"marks":[{"type":"line","from":{"data":"8a174100-d128-44ee-9473-f1373d6619d6"},"properties":{"enter":{"x":{"scale":"x","field":"data.x"},"y":{"scale":"y","field":"data.y"},"interpolate":{"value":"step-before"},"fill":{"value":"steelblue"},"fillOpacity":{"value":0.4},"stroke":{"value":"steelblue"},"strokeWidth":{"value":2},"strokeOpacity":{"value":1}}}},{"type":"line","from":{"data":"e3db35ce-b7f4-4bfa-8c73-24a93ec3afc4"},"properties":{"enter":{"x":{"scale":"x","field":"data.x"},"y":{"scale":"y","field":"data.y"},"stroke":{"value":"#FF29D2"},"strokeWidth":{"value":2},"strokeOpacity":{"value":1}}}}]},"value":"#gorilla_repl.vega.VegaView{:content {:width 400, :height 247.2188, :padding {:top 10, :left 55, :bottom 40, :right 10}, :scales [{:name \"x\", :type \"linear\", :range \"width\", :zero false, :domain {:data \"8a174100-d128-44ee-9473-f1373d6619d6\", :field \"data.x\"}} {:name \"y\", :type \"linear\", :range \"height\", :nice true, :zero false, :domain {:data \"8a174100-d128-44ee-9473-f1373d6619d6\", :field \"data.y\"}}], :axes [{:type \"x\", :scale \"x\"} {:type \"y\", :scale \"y\"}], :data ({:name \"8a174100-d128-44ee-9473-f1373d6619d6\", :values ({:x -5.570597904962771, :y 0} {:x -5.31616886471027, :y 0.00786073790167646} {:x -5.061739824457769, :y 0.0} {:x -4.807310784205268, :y 0.00393036895083823} {:x -4.552881743952767, :y 0.01572147580335292} {:x -4.298452703700266, :y 0.01572147580335292} {:x -4.044023663447765, :y 0.019651844754191152} {:x -3.7895946231952644, :y 0.019651844754191152} {:x -3.5351655829427635, :y 0.04323405845922053} {:x -3.2807365426902626, :y 0.04323405845922053} {:x -3.0263075024377617, :y 0.06288590321341168} {:x -2.771878462185261, :y 0.09432885482011752} {:x -2.51744942193276, :y 0.09432885482011752} {:x -2.263020381680259, :y 0.10218959272179398} {:x -2.008591341427758, :y 0.08646811691844106} {:x -1.7541623011752572, :y 0.10218959272179398} {:x -1.4997332609227563, :y 0.1847273406893968} {:x -1.2453042206702554, :y 0.16114512698436745} {:x -0.9908751804177545, :y 0.17293623383688211} {:x -0.7364461401652536, :y 0.17293623383688211} {:x -0.4820170999127526, :y 0.2083095543944262} {:x -0.22758805966025164, :y 0.20044881649274973} {:x 0.02684098059224932, :y 0.21617029229610266} {:x 0.2812700208447503, :y 0.18079697173855858} {:x 0.5356990610972512, :y 0.17293623383688211} {:x 0.7901281013497521, :y 0.2083095543944262} {:x 1.044557141602253, :y 0.20044881649274973} {:x 1.298986181854754, :y 0.11005033062347044} {:x 1.5534152221072548, :y 0.15721475803352922} {:x 1.8078442623597557, :y 0.11398069957430867} {:x 2.062273302612257, :y 0.1297021753776616} {:x 2.3167023428647577, :y 0.10611996167263221} {:x 2.5711313831172586, :y 0.10611996167263221} {:x 2.8255604233697595, :y 0.07467701006592638} {:x 3.0799894636222604, :y 0.06288590321341168} {:x 3.3344185038747614, :y 0.07074664111508815} {:x 3.5888475441272623, :y 0.039303689508382304} {:x 3.843276584379763, :y 0.039303689508382304} {:x 4.0977056246322645, :y 0.05502516531173522} {:x 4.352134664884765, :y 0.01179110685251469} {:x 4.606563705137266, :y 0.019651844754191152} {:x 4.860992745389767, :y 0.02358221370502938} {:x 5.115421785642268, :y 0.00393036895083823} {:x 5.369850825894769, :y 0.00393036895083823} {:x 5.62427986614727, :y 0.00786073790167646} {:x 5.878708906399771, :y 0.0} {:x 6.133137946652272, :y 0.0} {:x 6.387566986904773, :y 0.0} {:x 6.6419960271572736, :y 0.0} {:x 6.8964250674097745, :y 0.0} {:x 7.150854107662275, :y 0.0} {:x 7.405283147914776, :y 0.00393036895083823} {:x 7.659712188167277, :y 0})} {:name \"e3db35ce-b7f4-4bfa-8c73-24a93ec3afc4\", :values ({:x -10, :y 7.453306344157342E-7} {:x -9.799999997019768, :y 1.2227136022020082E-6} {:x -9.599999994039536, :y 1.9859008895787535E-6} {:x -9.399999991059303, :y 3.1933568466554097E-6} {:x -9.199999988079071, :y 5.083869442630077E-6} {:x -8.999999985098839, :y 8.013059747248974E-6} {:x -8.799999982118607, :y 1.2504301246871565E-5} {:x -8.599999979138374, :y 1.9318683610927946E-5} {:x -8.399999976158142, :y 2.9549673525896843E-5} {:x -8.19999997317791, :y 4.474916120466938E-5} {:x -7.999999970197678, :y 6.709252957952864E-5} {:x -7.799999967217445, :y 9.959109066711276E-5} {:x -7.599999964237213, :y 1.463604937211866E-4} {:x -7.399999961256981, :y 2.129532625969202E-4} {:x -7.199999958276749, :y 3.0676215890329826E-4} {:x -6.999999955296516, :y 4.3749825786254407E-4} {:x -6.799999952316284, :y 6.177431317230414E-4} {:x -6.599999949336052, :y 8.635680737170301E-4} {:x -6.39999994635582, :y 0.0011952046815864247} {:x -6.1999999433755875, :y 0.0016377403466157404} {:x -5.999999940395355, :y 0.002221799506292808} {:x -5.799999937415123, :y 0.002984157484620092} {:x -5.599999934434891, :y 0.003968219313121465} {:x -5.3999999314546585, :y 0.005224282454218924} {:x -5.199999928474426, :y 0.006809491580088464} {:x -4.999999925494194, :y 0.008787387543070678} {:x -4.799999922513962, :y 0.011226953610745277} {:x -4.5999999195337296, :y 0.014201072062040727} {:x -4.399999916553497, :y 0.017784325124320887} {:x -4.199999913573265, :y 0.022050107061901632} {:x -3.999999910593033, :y 0.027067059067306068} {:x -3.7999999076128006, :y 0.032894894202544614} {:x -3.5999999046325684, :y 0.03957974321387936} {:x -3.399999901652336, :y 0.04714921925263572} {:x -3.199999898672104, :y 0.0556074645983085} {:x -2.9999998956918716, :y 0.06493049855125375} {:x -2.7999998927116394, :y 0.07506222540759178} {:x -2.599999889731407, :y 0.08591147779981703} {:x -2.399999886751175, :y 0.09735045780688895} {:x -2.1999998837709427, :y 0.10921489230961066} {:x -1.9999998807907104, :y 0.12130613917293559} {:x -1.7999998778104782, :y 0.13339536950647682} {:x -1.599999874830246, :y 0.1452298146860898} {:x -1.3999998718500137, :y 0.1565409146696238} {:x -1.1999998688697815, :y 0.1670540488540041} {:x -0.9999998658895493, :y 0.17649938643452168} {:x -0.799999862909317, :y 0.18462327433935283} {:x -0.5999998599290848, :y 0.1911995003838428} {:x -0.39999985694885254, :y 0.19603973746572148} {:x -0.1999998539686203, :y 0.19900249729156638} {:x 1.4901161193847656E-7, :y 0.19999999999999946} {:x 0.20000015199184418, :y 0.1990024943261981} {:x 0.4000001549720764, :y 0.19603973162328203} {:x 0.6000001579523087, :y 0.19119949183655915} {:x 0.8000001609325409, :y 0.1846232633349483} {:x 1.0000001639127731, :y 0.1764993732842929} {:x 1.2000001668930054, :y 0.1670540339182087} {:x 1.4000001698732376, :y 0.15654089834113458} {:x 1.6000001728534698, :y 0.14522979737334754} {:x 1.800000175833702, :y 0.1333953516167646} {:x 2.0000001788139343, :y 0.12130612109691333} {:x 2.2000001817941666, :y 0.109214874407896} {:x 2.400000184774399, :y 0.09735044039927186} {:x 2.600000187754631, :y 0.08591146115746827} {:x 2.8000001907348633, :y 0.07506220974839269} {:x 3.0000001937150955, :y 0.06493048403815777} {:x 3.2000001966953278, :y 0.055607451340457185} {:x 3.40000019967556, :y 0.04714920730880908} {:x 3.6000002026557922, :y 0.03957973259776622} {:x 3.8000002056360245, :y 0.03289488488927549} {:x 4.000000208616257, :y 0.02706705100069495} {:x 4.200000211596489, :y 0.02205010016188641} {:x 4.400000214576721, :y 0.017784319294165653} {:x 4.600000217556953, :y 0.014201067194954814} {:x 4.800000220537186, :y 0.011226949595674444} {:x 5.000000223517418, :y 0.008787384269514283} {:x 5.20000022649765, :y 0.006809488941886312} {:x 5.400000229477882, :y 0.0052242803523266925} {:x 5.600000232458115, :y 0.003968217657451668} {:x 5.800000235438347, :y 0.002984156195065413} {:x 6.000000238418579, :y 0.0022217985130712366} {:x 6.200000241398811, :y 0.001637739590084685} {:x 6.400000244379044, :y 0.0011952041116685484} {:x 6.600000247359276, :y 8.635676490676143E-4} {:x 6.800000250339508, :y 6.177428187500568E-4} {:x 7.00000025331974, :y 4.3749802968947785E-4} {:x 7.2000002562999725, :y 3.0676199434329435E-4} {:x 7.400000259280205, :y 2.1295314518666783E-4} {:x 7.600000262260437, :y 1.46360410845439E-4} {:x 7.800000265240669, :y 9.959103279023577E-5} {:x 8.000000268220901, :y 6.709248958927605E-5} {:x 8.200000271201134, :y 4.47491338652843E-5} {:x 8.400000274181366, :y 2.9549655032275533E-5} {:x 8.600000277161598, :y 1.9318671232486508E-5} {:x 8.80000028014183, :y 1.2504293048415349E-5} {:x 9.000000283122063, :y 8.013054374075417E-6} {:x 9.200000286102295, :y 5.083865957875547E-6} {:x 9.400000289082527, :y 3.193354610174078E-6} {:x 9.60000029206276, :y 1.9858994691522355E-6} {:x 9.800000295042992, :y 1.2227127094295497E-6})}), :marks ({:type \"line\", :from {:data \"8a174100-d128-44ee-9473-f1373d6619d6\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :y {:scale \"y\", :field \"data.y\"}, :interpolate {:value \"step-before\"}, :fill {:value \"steelblue\"}, :fillOpacity {:value 0.4}, :stroke {:value \"steelblue\"}, :strokeWidth {:value 2}, :strokeOpacity {:value 1}}}} {:type \"line\", :from {:data \"e3db35ce-b7f4-4bfa-8c73-24a93ec3afc4\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :y {:scale \"y\", :field \"data.y\"}, :stroke {:value \"#FF29D2\"}, :strokeWidth {:value 2}, :strokeOpacity {:value 1}}}})}}"}
;; <=

;; @@

;; @@
