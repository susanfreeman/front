let body = document.getElementsByTagName("body")[0];
let href = window.location.href;

let dom1 = "";
let dom2 = "";
if(href.includes("en-us")) {
	dom1 = `
				<div class="head_inner">
					<span>
						<a href="/index.html"><img href="/index.html" class="logo" src="/img/depay.png" /></a>
						<img class="menu" src="/img/menu.png" />
						<img class="close" src="/img/close.png" />
					</span>
					<div>
						<div class="pc_btn">
							<a class="login" href="http://127.0.0.1:10008/web-app/Login">Sign In</a>
							<a class="register" href="/web-app/agreement">Register</a>
						</div>
						<a href="rights.html">card equity</a>
						<a class="pc_hide" href="faq.html">Q&A</a>
						<a class="pc_hide" href="download.html">Download App</a>
						<a href="google-authenticator.html">Google Authenticator</a>
						<a class="lang_outer">
							ENGLISH
							<img class="arrow" src="/img/arrow_bottom.png" />
							<span class="lang">
								<p data-lang="zh-cn">简体中文</p>
								<p data-lang="en-us">ENGLISH</p>
							</span>
						</a>
					</div>
				</div>
	`

	dom2 = `
			<div class="footer_inner">
				<div class="footer_l">
					<img src="/img2/orbiter_white.png" />
					<p>THE WORLD IN YOUR WALLET<span>Copyright © 2021-2024 orbiterwallet</span></p>
				</div>
				<div class="footer_r">
					<a class="telegram" href="https://t.me/+5PVX1nJZaJVkNmNl">
						<img src="/img/Telegram.png" />
						<label>Join the official Telegram group</label>
					</a>
					<div class="jump">
						<a href="https://t.me/orbiterwalletgroup" class="twitter">
							<img src="/img/twitter.png" />
							@orbiterwallet
						</a>
						<p>
							<img src="/img/email.png" />
							orbiterwallet@gmail.com
						</p>
					</div>
				</div>
			</div>

		`
} else {
	dom1 = `
			<div class="head_inner">
				<span>
					<a href="index.html"><img href="index.html" class="logo" src="img/depay.png" /></a>
					<img class="menu" src="img/menu.png" />
					<img class="close" src="img/close.png" />
				</span>
				<div>
					<div class="pc_btn">
						<a class="login" href="/web-app/Login">登录</a>
						<a class="register" href="/web-app/agreement">注册</a>
					</div>
					<a href="rights.html">卡片权益</a>
					<a href="faq.html">帮助中心</a>
					<a class="pc_hide" href="download.html">下载APP</a>
					<a href="google-authenticator.html">谷歌身份验证器</a>
					<a class="lang_outer">
						简体中文
						<img class="arrow" src="img/arrow_bottom.png" />
						<span class="lang">
							<p data-lang="zh-cn">简体中文</p>
							<p data-lang="en-us">ENGLISH</p>
						</span>
					</a>
				</div>
			</div>
`

	dom2 = `
			<div class="footer_inner">
				<div class="footer_l">
					<img src="../img2/orbiter_white.png" />
					<p>THE WORLD IN YOUR WALLET<span>Copyright © 2021-2024 orbiterwallet</span></p>
				</div>
				<div class="footer_r">
					<a class="telegram" href="https://t.me/+5PVX1nJZaJVkNmNl">
						<img src="/img/Telegram.png" />
						<label>加入官方Telegram群</label>
					</a>
					<div class="jump">
						<a href="https://t.me/orbiterwalletgroup" class="twitter">
							<img src="/img/twitter.png" />
							@orbiterwallet
						</a>
						<p>
							<img src="/img/email.png" />
							orbiterwallet@gmail.com
						</p>
					</div>
				</div>
			</div>

		`
}

//let header = document.createElement("div");
//header.setAttribute("class", "head");
//header.innerHTML = dom1;
//var first = document.body.firstChild;
//body.insertBefore(header, first);
let header = document.querySelector(".head")
let menu = document.querySelector(".menu")
menu.onclick = function() {
	header.setAttribute("class", "head head_show");
}

let close = document.querySelector(".close")
close.onclick = function() {
	header.setAttribute("class", "head");
}

$(".lang_outer").click(function() {
	$(".lang,.lang_mask").show();
})

$(".lang_mask").click(function() {
	$(".lang_outer,.lang").hide();
})

$(".lang p").click(function() {
	let lang = $(this).attr("data-lang");
	let href2 = window.location.pathname;
	let thref3 = window.location.pathname.split("/");
	// 去掉空字符
	let href3 = thref3.slice(1, thref3.length);

	if(href2.includes("en-us")) {
		if(lang == "en-us") {
			window.location.reload()
			return;
		}
		if(href.includes("index.html")) {
			href3.splice(0, 2);
		} else {
			href3.splice(0, 1, 'zh_cn')
		}
	} else {

		if(lang == "zh-cn") {
			window.location.reload();
			return;
		}
		if(href.includes("index.html")) {
			href3.splice(0, 0, "en-us")
		} else {
			// href3.splice(0, 1)
			href3.splice(0, 1, "en-us")
		}
	}
	href3 = "/" + href3.join("/");
	window.location.href = href3
})

let footer = document.createElement("div");
footer.setAttribute("class", "footer");
footer.innerHTML = dom2;
body.appendChild(footer);

//let menu1 = document.querySelector(".menu1");
//let head_list = document.querySelector(".h5_header_r");
//let is_hide = true;
//let t;
//menu1.onclick = function() {
//	if(is_hide) {
//		head_list.style.display = "block";
//	} else {
//		head_list.style.display = "none";
//	}
//	is_hide = !is_hide;
//	if(!is_hide) {
//		header.setAttribute("class", "header header_bg");
//	} else {
//		header.setAttribute("class", "header");
//	}
//}
//
//let menu2 = document.querySelector(".menu2");
//menu2.onclick = function() {
//	if(is_hide) {
//		head_list.style.display = "block";
//	} else {
//		head_list.style.display = "none";
//	}
//	is_hide = !is_hide;
//	if(t > distance) {
//		header.setAttribute("class", "header header_bg");
//	} else {
//		header.setAttribute("class", "header");
//	}
//
//}

//let distance = document.querySelector(".introduce1").offsetHeight;
//window.onscroll = function() {
//	t = document.documentElement.scrollTop || document.body.scrollTop;
//	if(t > distance) {
//		header.setAttribute("class", "header header_bg");
//	} else {
//		header.setAttribute("class", "header");
//	}
//}

var link = document.createElement('link');
link.type = 'image/x-icon';
link.rel = 'shortcut icon';
link.href = '../img/dupay.ico';
document.getElementsByTagName('head')[0].appendChild(link);

(function(c, l, a, r, i, t, y) {
	c[a] = c[a] || function() {
		(c[a].q = c[a].q || []).push(arguments)
	};
	t = l.createElement(r);
	t.async = 1;
	t.src = "https://www.clarity.ms/tag/" + i;
	y = l.getElementsByTagName(r)[0];
	y.parentNode.insertBefore(t, y);
})(window, document, "clarity", "script", "frbl4jplc1");
