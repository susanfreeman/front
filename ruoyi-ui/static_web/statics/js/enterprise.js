/* PLEASE DO NOT COPY AND PASTE THIS CODE. */
(function() {
    var w = window,
    C = '___grecaptcha_cfg',
    cfg = w[C] = w[C] || {},
    N = 'grecaptcha';
    var E = 'enterprise',
    a = w[N] = w[N] || {},
    gr = a[E] = a[E] || {};
    gr.ready = gr.ready ||
    function(f) { (cfg['fns'] = cfg['fns'] || []).push(f);
    };
    w['__recaptcha_api'] = 'https://www.recaptcha.net/recaptcha/enterprise/'; (cfg['enterprise'] = cfg['enterprise'] || []).push(true); (cfg['enterprise2fa'] = cfg['enterprise2fa'] || []).push(true); (cfg['render'] = cfg['render'] || []).push('6Lej2MUoAAAAAG71YWv_MDf-CK6005kXymq5s0kQ');
    w['__google_recaptcha_client'] = true;
    var d = document,
    po = d.createElement('script');
    po.type = 'text/javascript';
    po.async = true;
    po.charset = 'utf-8';
    po.src = 'https://www.gstatic.cn/recaptcha/releases/EGbODne6buzpTnWrrBprcfAY/recaptcha__en.js';
    po.crossOrigin = 'anonymous';
    po.integrity = 'sha384-zYfvuq6xV6aLevocYkVfLId59jcIkDZniQX2TsTt9LIa0Tf1ORHFh4oKI1naLgGF';
    var e = d.querySelector('script[nonce]'),
    n = e && (e['nonce'] || e.getAttribute('nonce'));
    if (n) {
        po.setAttribute('nonce', n);
    }
    var s = d.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(po, s);
})();