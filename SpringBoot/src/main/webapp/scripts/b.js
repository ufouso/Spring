(function(H) {
	var z = {},
		na = {},
		oa = {
			version: "0.0.2",
			token: "",
			partner: "",
			appName: "",
			enabled: !0,
			timeout: 2E3,
			timestamp: "-",
			fpHost: "https://fp.fraudmetrix.cn",
			jsonUrl: "/fp/profile.json",
			staticHost: "static.fraudmetrix.cn",
			flashUrl: "/clear.swf?v1=2",
			containers: {
				flash: null
			}
		},
		za = function(a) {
			var b = a;
			a instanceof Error && (b = encodeURIComponent((a.name + ":" + a.message + "|" + (a.lineNumber || 0) + ":" + (a.columnNumber || 0) + "|" + (a.stack || "no_stack")).replace(/\s+/g, "_")));
			(new Image).src = ("https:" == document.location.protocol ? "https://" : "http://") + (_fmOpt.staticHost || oa.staticHost) + "/error?partner=" + _fmOpt.partner + "&app=" + _fmOpt.appName + "&error=" + b + "&random=" + Math.random()
		};
	try {
		var O = [10, 8, 7, 3, 2],
			h = window,
			u = h.document,
			v = h.navigator,
			B = 0,
			F = !1,
			C = null,
			w = null,
			I = !1,
			Y, J = null,
			m = {},
			pa, K, P, G, Aa = function() {
				var a = u.getElementById != H && u.getElementsByTagName != H && u.createElement != H,
					b = v.userAgent.toLowerCase(),
					c = v.platform.toLowerCase(),
					d = c ? /win/.test(c) : /win/.test(b),
					c = c ? /mac/.test(c) : /mac/.test(b),
					e = /webkit/.test(b) ? parseFloat(b.replace(/^.*webkit\/(\d+(\.\d+)?).*$/, "$1")) : !1,
					g = /msie/.test(b);
				/opera/.test(b);
				var b = !e && /gecko/.test(b),
					l, f, p = [0, 0, 0];
				if (h.ActiveXObject instanceof Function) {
					g = !0;
					l = !1;
					try {
						l = new ActiveXObject("ShockwaveFlash.ShockwaveFlash")
					} catch (D) {}
					if (l) try {
						if (f = l.GetVariable("$version")) f = f.split(" ")[1].split(","), p = [parseInt(f[0], 10), parseInt(f[1], 10), parseInt(f[2], 10)]
					} catch (s) {}
				} else g = !1, (l = v.plugins && v.plugins["Shockwave Flash"] && v.mimeTypes && v.mimeTypes["application/x-shockwave-flash"] && v.mimeTypes["application/x-shockwave-flash"].enabledPlugin ? v.plugins["Shockwave Flash"] : !1) && l.description && (f = l.description.replace(/^.*\s+(\S+\s+\S+$)/, "$1"), p[0] = parseInt(f.replace(/^(.*)\..*$/, "$1"), 10), p[1] = parseInt(f.replace(/^.*\.(.*)\s.*$/, "$1"), 10), p[2] = /[a-zA-Z]/.test(f) ? parseInt(f.replace(/^.*[a-zA-Z]+(.*)$/, "$1"), 10) : 0);
				return {
					w3: a,
					flash: p,
					edit: 0,
					mod: 0,
					wk: e,
					gk: b,
					ie: g,
					win: d,
					mac: c
				}
			},
			E = function() {
				var a = [];
				return function(b) {
					m.debug && (window.Tracker ? Tracker.click("fm-" + b) : b && (a.push(b), setTimeout(function() {
						E(a.shift())
					}, 100)))
				}
			}(),
			A = function(a) {
				return /^[A-Z0-9]{112}$/.test(a)
			},
			Ba = function(a) {
				for (var b = 1, c = arguments.length; b < c; b++) for (var d in arguments[b]) arguments[b].hasOwnProperty(d) && (a[d] = arguments[b][d]);
				return a
			},
			L = {};
		(function() {
			var a = h.webkitRTCPeerConnection || h.mozRTCPeerConnection;
			a &&
			function() {
				function b(a) {
					a.split("\r\n").forEach(function(a) {
						if (~a.indexOf("a=candidate")) {
							a = a.split(" ");
							var b = a[4];
							"host" === a[7] && (L[b] = !0)
						} else~a.indexOf("c=") && (a = a.split(" "), b = a[2], L[b] = !0)
					})
				}
				try {
					var c = new a({
						iceServers: []
					});
					window.mozRTCPeerConnection && c.createDataChannel("", {
						reliable: !1
					});
					c.onicecandidate = function(a) {
						a.candidate && b(a.candidate.candidate)
					};
					c.createOffer(function(a) {
						b(a.sdp);
						c.setLocalDescription(a)
					}, function(a) {})
				} catch (d) {}
			}()
		})();
		var Ca = function() {
				var a = "";
				delete L["0.0.0.0"];
				for (var b in L) L.hasOwnProperty(b) ? a = a + "-" + b : a;
				return a
			},
			Ea = function() {
				return function(a, b, c) {
					var d = "_" + (new Date).getTime() + "_" + parseInt(1E4 * Math.random(), 10),
						e;
					e = [];
					for (var g in c || {}) e.push(encodeURIComponent(c[g]));
					e.push(d);
					c = "data=" + (m.version + "|");
					e = e.join("|");
					try {
						Da(a, c + e, b)
					} catch (l) {}
				}
			}(),
			Da = function(a, b, c) {
				var d;
				try {
					d = new ActiveXObject("Msxml2.XMLHTTP")
				} catch (e) {
					try {
						d = new ActiveXObject("Microsoft.XMLHTTP")
					} catch (g) {
						try {
							d = new XMLHttpRequest
						} catch (l) {}
					}
				}
				d.open("POST", a, !0);
				d.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				d.onreadystatechange = function() {
					if (4 == d.readyState && 200 == d.status) {
						var a = d.responseText;
						try {
							var b = eval("(" + a + ")");
							c(b.cd)
						} catch (e) {
							try {
								var g = a.indexOf('id="cd"');
								0 > g && c(JSON.parse(a));
								var g = a.indexOf("value=", g),
									l = a.indexOf("}", g),
									a = a.substring(g + 7, l + 1),
									b = eval("(" + a + ")");
								c(b)
							} catch (h) {
								c(JSON.parse(a))
							}
						}
					}
				};
				d.send(b)
			};
		z.getStatus = function(a) {
			return a ? B : 200 <= B
		};
		z.getFlashError = function() {};
		P = function(a) {
			return Z($(a, m.token))
		};
		z.init = function(a) {
			if (!I) {
				I = !0;
				try {
					m = Ba({}, oa, a || {})
				} catch (b) {}
				J = Aa.apply();
				B = 1;
				Y = setTimeout(K, m.timeout);
				m.debug && (z.options = m);
				if (m.enabled) try {
					pa()
				} catch (c) {
					E("init-error")
				}
			}
		};
		K = function() {
			var a, b = function(b, c) {
					if ("boolean" != typeof b && (!b || "-" == b)) return "-";
					switch (c) {
					case 0:
						"string" === typeof b && (b = "true" === b);
						a = b ? "1" : "0";
						break;
					case 1:
						a = parseInt(b, 10) || 0;
						break;
					case 2:
						b = "" + b;
						a = 32 < b.length ? b.substring(0, 32) : b;
						break;
					case 3:
						a = "" + b;
						break;
					default:
						a = "-"
					}
					return a
				},
				c = {
					set: function(a, b) {
						try {
							C && C.setCookie(a, b)
						} catch (c) {}
						try {
							h.localStorage && (localStorage[a] = b)
						} catch (d) {}
						try {
							h.sessionStorage && h.sessionStorage.setItem(a, b)
						} catch (p) {}
						if (v.cookieEnabled) {
							var D = a + "=" + encodeURIComponent(b),
								D = D + (";expires=" + (new Date((new Date).getTime() + 31536E6)).toGMTString() + "; path=/");
							u.cookie = D
						}
						if (J.ie && w) {
							var s;
							try {
								s = w.XMLDocument.documentElement
							} catch (k) {}
							s = s || w;
							s.setAttribute(a, b);
							try {
								w.save("fm")
							} catch (m) {}
						}
						if (!h.name || A(h.name)) h.name = b;
						G = b
					},
					get: function(a, b) {
						var d, f = "",
							p = 0;
						b == H && (b = 255);
						if (F) try {
							d = C.getCookie(a) || "", !f && b & 1 && (f = A(d) && d), p += O[0]
						} catch (D) {}
						try {
							h.localStorage && (d = localStorage[a] || "", !f && b & 4 && (f = A(d) && d), p += O[2])
						} catch (s) {}
						try {
							h.sessionStorage && (d = h.sessionStorage.getItem(a) || "", !f && b & 1 && (f = A(d) && d))
						} catch (k) {}
						if (w) {
							try {
								w.load("fm")
							} catch (m) {}
							var n;
							try {
								n = w.XMLDocument.documentElement
							} catch (q) {}
							n = n || w;
							d = n.getAttribute(a);
							!f && b & 8 && (f = A(d) && d);
							p += O[3]
						}
						v.cookieEnabled && (d = u.cookie.indexOf(a + "="), -1 != d && (d += a.length + 1, n = u.cookie.indexOf(";", d), -1 == n && (n = u.cookie.length), d = decodeURIComponent(u.cookie.substring(d, n)) || "", !f && b & 16 && (f = A(d) && d)), p += O[4]);
						d = h.name;
						f || (f = A(d) && d);
						d = G;
						f || (f = A(d) && d);
						255 == b && E("points-" + p);
						f && 255 == b && c.set(a, f);
						return f
					},
					remove: function(a, b) {
						b == H && (b = 255);
						v.cookieEnabled && b & 16 && (u.cookie = a + "=;expires=Thu, 01-Jan-70 00:00:01 GMT;");
						if (J.ie && b & 8 && w) {
							w.removeAttribute(a);
							try {
								w.save("fm")
							} catch (c) {}
						}
						try {
							b & 4 && h.localStorage && localStorage.removeItem(a), b & 1 && F && C.setCookie(a, "")
						} catch (d) {}
					}
				},
				d = [{
					avHardwareDisable: [0, 0],
					isEmbeddedInAcrobat: [0, 0],
					hasAudio: [0, 0],
					hasMP3: [0, 0],
					hasPrinting: [0, 0],
					hasStreamingAudio: [0, 0],
					hasStreamingVideo: [0, 0],
					hasVideoEncoder: [0, 0],
					hasAccessibility: [0, 0],
					hasEmbeddedVideo: [0, 0],
					hasScreenBroadcast: [0, 0],
					hasScreenPlayback: [0, 0],
					maxLevelIDC: [1, 0],
					zding_hasIME: [0, 0],
					zding_touchscreenType: [2, 0]
				}, {
					width: [1, 2],
					height: [1, 2],
					availWidth: [1, 2],
					availHeight: [1, 2],
					clientWidth: [1, 3],
					clientHeight: [1, 3],
					screenColor: [2, 0],
					screenDPI: [1, 0],
					screenResolutionX: [1, 0],
					screenResolutionY: [1, 0],
					screenTop: [1, 5, function() {
						return "number" == typeof h.screenLeft ? h.screenLeft : h.screenX
					}],
					screenLeft: [1, 5, function() {
						return "number" == typeof h.screenTop ? h.screenTop : h.screenY
					}],
					location: [3, 4, function(a) {
						return a ? encodeURIComponent(a.href.slice(0, 255)) : ""
					}],
					timezone: [1, 5, function() {
						var a = new Date;
						a.setDate(1);
						a.setMonth(5);
						var b = -a.getTimezoneOffset();
						a.setMonth(11);
						a = -a.getTimezoneOffset();
						return Math.min(b, a)
					}],
					timestamp: [3, 5, function() {
						return (new Date).getTime()
					}],
					zding_supports32BitProcesses: [0, 0],
					zding_supports64BitProcesses: [0, 0],
					zding_maxTouchPoints: [1, 1],
					ethIp: [3, 5, Ca],
					zding_colorDepth: [1, 2]
				}, {
					playerType: [2, 0],
					version: [2, 0],
					appCodeName: [2, 1],
					appMinorVersion: [2, 1],
					appName: [2, 1],
					appVersion: [2, 1],
					cookieEnabled: [0, 1],
					doNotTrack: [0, 1],
					language: [2, 0],
					languages: [2, 0],
					systemLanguage: [2, 1],
					userLanguage: [2, 1],
					browserLanguage: [2, 1],
					manufacturer: [2, 0],
					fonts: [2, 0],
					os: [2, 0],
					oscpu: [2, 1],
					cpuClass: [2, 1],
					platform: [2, 1, function(a) {
						return a ? a.split(" ").shift() : ""
					}],
					zding_cpuArchitecture: [2, 0]
				}];
			return function() {
				if (!arguments.callee.invoked && I) {
					arguments.callee.invoked = !0;
					B = 3;
					window.__flash__removeCallback = function(a, b) {
						a && (a[b] = null)
					};
					w = u.getElementById("fmData");
					C = u.getElementById("fmFlash");
					try {
						F || (F = C && C.md5)
					} catch (a) {}
					var g = {
						partner_code: m.partner,
						app_name: m.appName,
						token_id: m.token || ""
					};
					try {
						for (var l = 0; 3 > l; l++) {
							var f = [],
								p = [],
								D = d[l],
								s;
							for (s in D) D.hasOwnProperty(s) && f.push(s);
							for (var f = f.sort(), k = 0, r = f.length; k < r; k++) {
								var n = d[l][f[k]],
									q = "";
								try {
									switch (n[1]) {
									case 0:
										(q = F && C.getCapabilities(f[k].replace("zding_", "")) || "") && n[2] && (q = n[2](q));
										break;
									case 1:
										(q = v[f[k]] || "") && n[2] && (q = n[2](q));
										break;
									case 2:
										(q = h.screen[f[k].replace("zding_", "")] || "") && n[2] && (q = n[2](q));
										break;
									case 3:
										(q = u.body[f[k]] || "") && n[2] && (q = n[2](q));
										break;
									case 4:
										(q = h[f[k]] || "") && n[2] && (q = n[2](q));
										break;
									case 5:
										n[2] && (q = n[2]())
									}
								} catch (x) {}
								p.push(b(q, n[0]))
							}
							g["param" + l] = P(p.join("^^"))
						}
					} catch (y) {
						E("err-read")
					}
					g.param0 = g.param0 || "";
					g.param1 = g.param1 || "";
					g.param2 = g.param2 || "";
					g.paramy = "1^^";
					g.paramy = F ? g.paramy + "1^^" : g.paramy + "0^^";
					g.paramy += _fmOpt.imgLoaded ? "1" : "0";
					var t;
					try {
						t = g.paramx = c.get("_fmdata")
					} catch (z) {
						E("err-read-s")
					}
					h.attachEvent && h.attachEvent("onunload", function() {
						G ? c.set("_fmdata", G) : c.get("_fmdata", 255)
					});
					h.addEventListener && h.addEventListener("unload", function() {
						G ? c.set("_fmdata", G) : c.get("_fmdata", 255)
					});
					B = 4;
					try {
						Ea(m.fpHost + m.jsonUrl, function(a) {
							Y && clearTimeout(Y);
							a && "id" in a ? (B = 255, (t = a.id) && c.set("_fmdata", t)) : B = 200
						}, g)
					} catch (A) {}
				}
			}
		}();
		pa = function() {
			z.flashLoaded = function() {
				!arguments.callee.invoked && I && (F = arguments.callee.invoked = !0, K())
			};
			var a = function() {
					var a = ("https:" == document.location.protocol ? "https://" : "http://") + m.staticHost + m.flashUrl,
						a = '<object type="application/x-shockwave-flash" data="' + a + '" width="1" height="1" id="fmFlash"><param name="movie" value="' + a + '" /><param name="allowScriptAccess" value="always" /></object>',
						c = document.createElement("div");
					c.innerHTML = a;
					c.style.position = "absolute";
					c.style.bottom = 0;
					!
					function() {
						var a = m.containers.flash ? m.containers.flash : document.body;
						a ? a.insertBefore(c, a.firstChild) : setTimeout(arguments.callee, 100)
					}()
				};
			return function() {
				if (!arguments.callee.invoked && I) {
					arguments.callee.invoked = !0;
					B = 2;
					try {
						if (J.ie) {
							var b = document.createElement("span");
							b.innerHTML = '<input type="hidden" id="fmData" style="behavior:url(#default#userData)"/>';
							document.body.insertBefore(b.firstChild, document.body.firstChild)
						}
					} catch (c) {
						E("err-ud")
					}
					if (9 <= J.flash[0]) try {
						a()
					} catch (d) {
						E("err-fl"), K()
					} else E("no-flash"), K()
				}
			}
		}();
		var t = "",
			x, aa, ba, M, Q = 0,
			qa, N, R = NaN,
			S = !1,
			T = !1,
			ca = {},
			ra = {},
			da = {},
			U, V, W, sa, Fa = 0;
		U = function(a) {
			var b = a || window.event;
			if ("mousemove" != b.type || 0 == Fa++ % 30) {
				var c = (new Date).getTime() - M,
					d = ++Q,
					e = ea(b.target || b.srcElement),
					g = document.body;
				k(10, [c, ca[b.type], d, "mousedown" == b.type ? b.which ? b.which : [0, 1, 3, 0, 2][b.button] : 0, e, a.pageX || a.clientX + (g ? g.scrollLeft || 0 : 0), a.pageY || a.clientY + (g ? g.scrollHeight || 0 : 0), b.clientX, b.clientY])
			}
		};
		V = function(a) {
			a = a || window.event;
			var b = (new Date).getTime() - M,
				c = a.target || a.srcElement;
			if ("input" != c.tagName.toLowerCase() || "password" != c.type.toLowerCase()) {
				var d = ++Q,
					e = ea(c),
					g = a.keyCode,
					l = 0;
				a.ctrlKey && 17 != g && (l += 1);
				a.altKey && 18 != g && (l += 2);
				a.shiftKey && 16 != g && (l += 4);
				a.metaKey && 91 != g && (l += 8);
				k(11, [b, ra[a.type], d, g, l, e, c.value])
			}
		};
		W = function(a) {
			a = a || window.event;
			var b = (new Date).getTime() - M,
				c = ++Q;
			k(12, [b, da[a.type], c])
		};
		sa = function(a) {
			a = a || window.event;
			(a.target || a.srcElement || this).getAttribute("guid") == ba && (a = (new Date).getTime(), k(9, [void 0, a]))
		};
		var y = function(a) {
				"function" === (typeof a).toLowerCase() && (a = "" + a);
				if (null == a) return null;
				for (var b = 64222, c = 0; c < a.length; c++) b ^= (b << 8) + (b >>> 3) + a.charCodeAt(c);
				return b
			},
			X, $ = function(a, b) {
				X();
				for (var c = "", d = y(b) >> 3 & 255, e = 0; e < a.length; e++) c += String.fromCharCode((a.charCodeAt(e) ^ (0 == e ? d : c.charCodeAt(e - 1))) & 255);
				return c
			},
			ta = function(a, b) {
				for (var c = a.length; c--;) if (a[c] === b) return !0;
				return !1
			},
			r = "abcdefghijklmnoqprstuvwxyz",
			Z = function(a) {
				X();
				for (var b = "", c, d = 0; a.length >= d + 3;) c = (a.charCodeAt(d++) & 255) << 16 | (a.charCodeAt(d++) & 255) << 8 | a.charCodeAt(d++) & 255, b += r.charAt((c & 16515072) >> 18), b += r.charAt((c & 258048) >> 12), b += r.charAt((c & 4032) >> 6), b += r.charAt(c & 63);
				0 < a.length - d && (c = (a.charCodeAt(d++) & 255) << 16 | (a.length > d ? (a.charCodeAt(d) & 255) << 8 : 0), b += r.charAt((c & 16515072) >> 18), b += r.charAt((c & 258048) >> 12), b += a.length > d ? r.charAt((c & 4032) >> 6) : "=", b += "=");
				return b
			},
			k = function(a, b) {
				var c = (new Date).getTime(); + [][
					[]
				] && X();
				var d = (11 < t.length ? "^" : "") + Z($(a + Ga(b).replace(/[\t\r\n\x0b\x0c]/g, " "), t));
				(t + d).length > R ? (S = !1, T && (fa(["mousedown", "mousemove"], U, document), fa(["keydown"], V, document), fa(["focus", "blur"], W, window), T = !1)) : S && (t += d, x ? x.value = t : window[aa] = t, _fmOpt.debug && window.console && console.log && console.log("record data with type: " + a + " in " + ((new Date).getTime() - c) + "ms."))
			},
			ga = function(a) {
				ba = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g, function(a) {
					var c = 16 * Math.random() | 0;
					return ("x" == a ? c : c & 3 | 8).toString(16)
				});
				M = (new Date).getTime();
				k(0, [ba, M, a.partner + "_" + a.appName, a.token])
			},
			ua = function() {
				var a = [navigator.userAgent, navigator.platform, -1 * (new Date).getTimezoneOffset(), (navigator.language || navigator.userLanguage).toLowerCase()];
				k(1, a)
			},
			ha = function() {
				var a = document.body;
				k(2, [window.mozInnerScreenX || window.screenLeft || 0, window.mozInnerScreenY || window.screenTop || 0, a ? a.clientWidth : 0, a ? a.clientHeight : 0, screen.width, screen.height, screen.availWidth, screen.availHeight])
			},
			va = function() {
				k(3, [])
			},
			wa = function() {
				isNaN(R) && k(4, [])
			},
			ia = function() {
				var a = [document.getElementsByTagName("iframe").length, document.forms.length, document.getElementsByTagName("input").length, document.getElementsByTagName("script").length, document.images.length];
				k(5, a)
			};
		qa = y(arguments.callee);
		var ja = function() {
				if (isNaN(R)) {
					for (var a = [], b = document.getElementsByTagName("script"), c = 0; c < b.length && 3 > c; c++) a.push("" == b[c].src ? y(b[c].text) : b[c].src);
					k(6, a)
				}
			},
			ka = [],
			Ha = function(a) {
				for (var b = 0, c = 0, d = a.offsetWidth, e = a.offsetHeight; a;) b += a.offsetLeft, c += a.offsetTop, a = a.offsetParent;
				return [b, c, d, e]
			},
			ea = function(a) {
				var b;
				b = a;
				for (var c = []; b && 1 == b.nodeType; b = b.parentNode) {
					var d = 0;
					if (b && b.id) {
						c.splice(0, 0, "#" + b.id);
						break
					}
					for (var e = b.previousSibling; e; e = e.previousSibling) 10 != e.nodeType && e.nodeName == b.nodeName && ++d;
					e = b.nodeName.toLowerCase();
					c.splice(0, 0, e + (d ? d : ""))
				}
				b = c.length ? c.join(">") : null;
				c = y(b);
				if (ta(ka, c)) return c;
				ka.push(c);
				k(7, [c, b].concat(Ha(a)));
				return c
			},
			xa = function() {
				k(8, [location.href, document.referrer, history.length, qa])
			},
			la = function(a, b, c) {
				for (var d in a) a.hasOwnProperty(d) && (c.addEventListener ? c.addEventListener(a[d], b, !0) : c.attachEvent("on" + a[d], b, !1))
			},
			fa = function(a, b, c) {
				for (var d in a) a.hasOwnProperty(d) && (c.removeEventListener ? c.removeEventListener(a[d], b, !0) : c.detachEvent("on" + a[d], b, !1))
			},
			r = r + "ABCDEFGHJIKLMNOPQRSTUVWXYZ",
			Ia = function(a, b) {
				var c = !1,
					d = !0,
					e = a.document,
					g = e.documentElement,
					l = e.addEventListener,
					f = l ? "addEventListener" : "attachEvent",
					h = l ? "removeEventListener" : "detachEvent",
					k = l ? "" : "on",
					s = function(d) {
						if ("readystatechange" != d.type || "complete" == e.readyState || "loaded" == e.readyState)("load" == d.type ? a : e)[h](k + d.type, s, !1), !c && (c = !0) && b.call(a, d.type || d)
					},
					m = function() {
						try {
							g.doScroll("left")
						} catch (a) {
							setTimeout(m, 50);
							return
						}
						s("poll")
					};
				if ("complete" == e.readyState || "loaded" == e.readyState) b.call(a, "lazy");
				else {
					if (!l && g.doScroll) {
						try {
							d = !a.frameElement
						} catch (r) {}
						d && m()
					}
					e[f](k + "DOMContentLoaded", s, !1);
					e[f](k + "readystatechange", s, !1);
					a[f](k + "load", s, !1)
				}
			};
		X = function() {
			if (!N) {
				N = {};
				var a = {};
				a[y($)] = [k, P];
				a[y(Z)] = [k, P];
				a[y(k)] = [ua, ha, ia, wa, ea, V, U, W, xa, va, ga, ja, sa, arguments.callee];
				for (var b in a) if (a.hasOwnProperty(b)) {
					var c = N[b] = [],
						d;
					for (d in a[b]) a[b].hasOwnProperty(d) && c.push(y(a[b][d]))
				}
			}
			a = arguments.callee.caller;
			b = y(a);
			b in N ? (c = y(a.caller), ta(N[b], c) || k(13, [0, "" + a.caller, b])) : k(13, [1, "" + a, b])
		};
		var Ga = function(a) {
				var b = /[\\\"\x00-\x1f\x7f-\xff\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\u0391-\uffe5\ufff0-\uffff]/g,
					c = {
						"\b": "\\b",
						"\t": "\\t",
						"\n": "\\n",
						"\f": "\\f",
						"\r": "\\r",
						'"': '\\"',
						"\\": "\\\\"
					},
					d = function(a) {
						b.lastIndex = 0;
						return b.test(a) ? '"' + a.replace(b, function(a) {
							var b = c[a];
							return "string" === typeof b ? b : "\\u" + ("0000" + a.charCodeAt(0).toString(16)).slice(-4)
						}) + '"' : '"' + a + '"'
					},
					e = function(a, b) {
						var c, k, h = b[a];
						switch (typeof h) {
						case "string":
							return d(h);
						case "number":
							return isFinite(h) ? String(h) : "null";
						case "object":
							if (!h) return "null";
							k = [];
							if ("[object Array]" === Object.prototype.toString.apply(h)) {
								c = h.length;
								for (var m = 0; m < c; m += 1) k[m] = e(m, h) || "null";
								return c = 0 === k.length ? "[]" : "[" + k.join(",") + "]"
							}
							return null;
						default:
							return null
						}
					};
				return e("", {
					"": a
				})
			},
			ya = function() {
				ua();
				va();
				wa();
				xa();
				T || (la(["mousedown", "mousemove"], U, document), la(["keydown"], V, document), la(["focus", "blur"], W, window), T = !0)
			};
		na.init = function(a) {
			!0 === a.bd && (a.limit && (R = a.limit), S = !0, ca.mousedown = 0, ca.mousemove = 1, ra.keydown = 0, da.focus = 0, da.blur = 1, t = "fraudmetrix".replace(/./g, function() {
				return r.charAt(64 * Math.random() | 0)
			}), a.form ? (x = document.createElement("input"), x.type = "hidden", x.name = "bdstr", x.id = "__bdstr_input__") : aa = a.name ? a.name : "bdstr", Ia(window, function() {
				if (a.form) {
					var b = document.getElementById(a.form);
					if (b) b.insertBefore(x, b.firstChild);
					else {
						var c = function() {
								(b = document.getElementById(a.form)) ? b.insertBefore(x, b.firstChild) : setTimeout(c, 100)
							};
						setTimeout(c, 100)
					}
				}
				ha();
				ia();
				ja()
			}), ga(a), ya(), a.restart = function() {
				S = !0;
				ka = [];
				x ? x.value = "" : window[aa] = "";
				t = "fraudmetrix".replace(/./g, function() {
					return r.charAt(64 * Math.random() | 0)
				});
				Q = 0;
				ha();
				ia();
				ja();
				ga(a);
				ya()
			})
		};
		for (var ma = 0; 10 > ma; ma++) r += String.fromCharCode(48 + ma);
		r += "~/";
		_fmOpt.flashLoaded = z.flashLoaded;
		window.fp = {};
		window.fp.flashLoaded = z.flashLoaded
	} catch (Ja) {
		za(Ja)
	}
	na.init(_fmOpt);
	z.init(_fmOpt)
})();