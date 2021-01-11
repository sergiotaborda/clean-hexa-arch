(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "+WAi":
/*!****************************************************!*\
  !*** ./src/app/gateways/authentication-gateway.ts ***!
  \****************************************************/
/*! exports provided: AuthenticationGateway */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthenticationGateway", function() { return AuthenticationGateway; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");


class AuthenticationGateway {
    authenticate(username, password) {
        return new Promise((resolve, reject) => {
            window.setTimeout(() => { resolve(); }, 0);
        });
    }
}
AuthenticationGateway.ɵfac = function AuthenticationGateway_Factory(t) { return new (t || AuthenticationGateway)(); };
AuthenticationGateway.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: AuthenticationGateway, factory: AuthenticationGateway.ɵfac });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AuthenticationGateway, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"]
    }], null, null); })();


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\Projetos\GitHub\clean-hexa-arch\src\angular-app\src\main.ts */"zUnb");


/***/ }),

/***/ "1ptk":
/*!*******************************************************!*\
  !*** ./src/app/interaction/views/login/login.view.ts ***!
  \*******************************************************/
/*! exports provided: LoginViewComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginViewComponent", function() { return LoginViewComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _app_route_paths__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../app.route.paths */ "p5LJ");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "tyNb");
/* harmony import */ var _toolkit_ui_toolkit__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../toolkit/ui-toolkit */ "H07S");
/* harmony import */ var _gateways_authentication_gateway__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../gateways/authentication-gateway */ "+WAi");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "3Pt+");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ngx-translate/core */ "sYmb");








class LoginViewComponent {
    constructor(router, ui, authenticationGateway) {
        this.router = router;
        this.ui = ui;
        this.authenticationGateway = authenticationGateway;
        this.credentials = { username: "", password: "" };
    }
    onLogin() {
        this.ui.waitFor(() => this.authenticationGateway.authenticate(this.credentials.username, this.credentials.password))
            .then(() => {
            return this.router.navigateByUrl(_app_route_paths__WEBPACK_IMPORTED_MODULE_1__["RoutePath"].Books);
        })
            .catch(() => {
            this.credentials.password = "";
        });
    }
}
LoginViewComponent.ɵfac = function LoginViewComponent_Factory(t) { return new (t || LoginViewComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_toolkit_ui_toolkit__WEBPACK_IMPORTED_MODULE_3__["UiToolkit"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_gateways_authentication_gateway__WEBPACK_IMPORTED_MODULE_4__["AuthenticationGateway"])); };
LoginViewComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: LoginViewComponent, selectors: [["login"]], decls: 53, vars: 30, consts: [[1, "login", "login-layout", "horizontal-layout", "must-expand-max-state"], [1, "horizontal-layout__item", "is-seven-tenths-state", "vertical-layout", "login__brand"], [1, "vertical-layout__item", "login__brand-header", "horizontal-layout"], [1, "horizontal-layout__item"], [1, "horizontal-layout__item", "login-layout__logo"], [1, "vertical-layout__item", "must-expand-double-state", "login__brand-footer", "horizontal-layout"], [1, "horizontal-layout__item", "vertical-layout"], [1, "vertical-layout__item"], [1, "vertical-layout__item", "vertical-layout"], [1, "login__brand-title"], [1, "login__brand-subtitle"], [1, "vertical-layout__item", "must-expand-double-state"], [1, "horizontal-layout", "horizontal-layout__item", "is-three-tenths-state"], [1, "horizontal-layout__item", "horizontal-layout__item", "vertical-layout"], [1, "vertical-layout__item", "is-three-tenths-state"], [1, "vertical-layout__item", "vertical-layout", "login-layout__header"], [1, "login__subtitle"], [1, "login__title"], [1, "login__line", "login-layout__line"], [1, "vertical-layout__item", "must-fit-content-state", "form", "form-layout", "form-layout--login"], [1, "form-layout__header"], [1, "form__title"], [1, "form-layout__content"], [1, "form-layout__field", "form-layout__field--login", "form__field", "horizontal-layout"], ["name", "username", "required", "", 1, "form-layout__input", "form__input", "form__input--login", 3, "ngModel", "placeholder", "ngModelChange"], [1, "form-layout__input-icon"], [1, "form-layout__field-separator"], ["name", "password", "type", "password", "required", "", 1, "form-layout__input", "form__input", "form__input--login", 3, "ngModel", "placeholder", "ngModelChange"], [1, "form-layout__toolbar", "form-layout__toolbar--login", "toolbar-layout"], ["type", "submit", 1, "toolbar-layout__item", "form__button", "button", "button--primary", "button-layout", 3, "click"], [1, "button__caption", "button-layout__caption"]], template: function LoginViewComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](4, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](5, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "span", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](13, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "span", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](16, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](17, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](18, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](20, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](22, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "div", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "span", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](26, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "span", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](28);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](29, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](30, "div", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](32, "div", 20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](33, "span", 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](34);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](35, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](36, "div", 22);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](37, "div", 23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](38, "input", 24);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function LoginViewComponent_Template_input_ngModelChange_38_listener($event) { return ctx.credentials.username = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](39, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](40, "div", 25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](41, "div", 26);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](42, "div", 23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](43, "input", 27);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function LoginViewComponent_Template_input_ngModelChange_43_listener($event) { return ctx.credentials.password = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](44, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](45, "div", 25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](46, "div", 28);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](47, "button", 29);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function LoginViewComponent_Template_button_click_47_listener() { return ctx.onLogin(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](48, "span", 30);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](49);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](50, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](51, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](52, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](13, 14, "APPLICATION.TITLE"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](16, 16, "APPLICATION.BRAND_SUBTITLE"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](26, 18, "APPLICATION.SUBTITLE"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](29, 20, "APPLICATION.TITLE"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](35, 22, "LOGIN.TITLE"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("has-value-state", ctx.credentials.username);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("placeholder", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](39, 24, "LOGIN.USERNAME"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.credentials.username);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("has-value-state", ctx.credentials.password);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("placeholder", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](44, 26, "LOGIN.PASSWORD"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.credentials.password);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](50, 28, "LOGIN.COMMAND.ENTER"));
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_5__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_5__["RequiredValidator"], _angular_forms__WEBPACK_IMPORTED_MODULE_5__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_5__["NgModel"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__["TranslatePipe"]], encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](LoginViewComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: "login",
                templateUrl: "./login.view.html"
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] }, { type: _toolkit_ui_toolkit__WEBPACK_IMPORTED_MODULE_3__["UiToolkit"] }, { type: _gateways_authentication_gateway__WEBPACK_IMPORTED_MODULE_4__["AuthenticationGateway"] }]; }, null); })();


/***/ }),

/***/ "AytR":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
const environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "ELJf":
/*!****************************************************!*\
  !*** ./src/app/interaction/interactions.module.ts ***!
  \****************************************************/
/*! exports provided: InteractionsModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InteractionsModule", function() { return InteractionsModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "ofXK");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ngx-translate/core */ "sYmb");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "3Pt+");
/* harmony import */ var _views_login_login_view__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./views/login/login.view */ "1ptk");
/* harmony import */ var _views_books_books_view__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./views/books/books.view */ "TUfd");







class InteractionsModule {
}
InteractionsModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: InteractionsModule });
InteractionsModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function InteractionsModule_Factory(t) { return new (t || InteractionsModule)(); }, providers: [], imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](InteractionsModule, { declarations: [_views_login_login_view__WEBPACK_IMPORTED_MODULE_4__["LoginViewComponent"],
        _views_books_books_view__WEBPACK_IMPORTED_MODULE_5__["BooksViewComponent"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](InteractionsModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"]
                ],
                declarations: [
                    _views_login_login_view__WEBPACK_IMPORTED_MODULE_4__["LoginViewComponent"],
                    _views_books_books_view__WEBPACK_IMPORTED_MODULE_5__["BooksViewComponent"]
                ],
                providers: []
            }]
    }], null, null); })();


/***/ }),

/***/ "G/O7":
/*!**********************************************!*\
  !*** ./src/app/toolkit/ui-toolkit.module.ts ***!
  \**********************************************/
/*! exports provided: UiToolkitModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UiToolkitModule", function() { return UiToolkitModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "ofXK");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ngx-translate/core */ "sYmb");
/* harmony import */ var _ui_toolkit__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./ui-toolkit */ "H07S");





class UiToolkitModule {
}
UiToolkitModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: UiToolkitModule });
UiToolkitModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function UiToolkitModule_Factory(t) { return new (t || UiToolkitModule)(); }, providers: [
        _ui_toolkit__WEBPACK_IMPORTED_MODULE_3__["UiToolkit"]
    ], imports: [[
            _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](UiToolkitModule, { declarations: [_ui_toolkit__WEBPACK_IMPORTED_MODULE_3__["WaitPanelComponent"]], imports: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
        _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateModule"]], exports: [_ui_toolkit__WEBPACK_IMPORTED_MODULE_3__["WaitPanelComponent"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UiToolkitModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [
                    _angular_common__WEBPACK_IMPORTED_MODULE_1__["CommonModule"],
                    _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateModule"]
                ],
                declarations: [
                    _ui_toolkit__WEBPACK_IMPORTED_MODULE_3__["WaitPanelComponent"]
                ],
                exports: [
                    _ui_toolkit__WEBPACK_IMPORTED_MODULE_3__["WaitPanelComponent"]
                ],
                providers: [
                    _ui_toolkit__WEBPACK_IMPORTED_MODULE_3__["UiToolkit"]
                ]
            }]
    }], null, null); })();


/***/ }),

/***/ "H07S":
/*!***************************************!*\
  !*** ./src/app/toolkit/ui-toolkit.ts ***!
  \***************************************/
/*! exports provided: NotificationBrokerProvider, UiToolkit, WaitContext, WaitPanelComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NotificationBrokerProvider", function() { return NotificationBrokerProvider; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UiToolkit", function() { return UiToolkit; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WaitContext", function() { return WaitContext; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WaitPanelComponent", function() { return WaitPanelComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "tyNb");
/* harmony import */ var ng_snotify__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ng-snotify */ "90Zs");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "qCKp");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "kU1M");
/* harmony import */ var _commons_errors__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../commons/errors */ "epUv");
/* harmony import */ var _commons_notifications__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../commons/notifications */ "JMaW");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ngx-translate/core */ "sYmb");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/common */ "ofXK");












function WaitPanelComponent_div_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](4, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "span", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](7, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("is-total-overlay-state", ctx_r0.isTotalOverlay);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("is-overlay-all-page-state", ctx_r0.isTotalOverlay);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](7, 5, "WAIT.DESCRIPTION"));
} }
const _c0 = ["*"];
const NotificationBrokerProvider = {
    provide: "SnotifyToastConfig",
    useValue: ng_snotify__WEBPACK_IMPORTED_MODULE_2__["ToastDefaults"]
};
class UiToolkit {
    constructor(router, translationService, snotifyService) {
        this.translationService = translationService;
        this.snotifyService = snotifyService;
        this.busyStates = new Map();
        const config = {};
        config.timeout = 6000;
        config.position = ng_snotify__WEBPACK_IMPORTED_MODULE_2__["SnotifyPosition"].rightTop;
        config.closeOnClick = true;
        config.showProgressBar = false;
        config.pauseOnHover = false;
        config.bodyMaxLength = 400;
        this.snotifyService.setDefaults({ toast: config });
        router.events.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["filter"])(event => event instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationStart"])).subscribe(() => this.snotifyService.clear());
    }
    handleError(error) {
        if (error instanceof _commons_errors__WEBPACK_IMPORTED_MODULE_5__["ValidationError"]) {
            for (const reason of error.reasons()) {
                this.notify(new _commons_notifications__WEBPACK_IMPORTED_MODULE_6__["MessageNotification"](_commons_notifications__WEBPACK_IMPORTED_MODULE_6__["NotificationType"].Warning, reason.message, reason.messageParameters));
            }
        }
        else {
            const holder = error;
            if (holder.NotificationType) {
                this.notify(holder);
            }
            else {
                this.notify(new _commons_notifications__WEBPACK_IMPORTED_MODULE_6__["MessageNotification"](_commons_notifications__WEBPACK_IMPORTED_MODULE_6__["NotificationType"].Error, "ERROR.SYSTEM.UNEXPECTED"));
            }
        }
    }
    notify(notification) {
        this.translationService.get(notification.message, notification.messageParameters).toPromise().then(text => {
            let method;
            switch (notification.type) {
                case _commons_notifications__WEBPACK_IMPORTED_MODULE_6__["NotificationType"].Warning:
                    method = this.snotifyService.warning;
                    break;
                case _commons_notifications__WEBPACK_IMPORTED_MODULE_6__["NotificationType"].Success:
                    method = this.snotifyService.success;
                    break;
                case _commons_notifications__WEBPACK_IMPORTED_MODULE_6__["NotificationType"].Information:
                    method = this.snotifyService.info;
                    break;
                case _commons_notifications__WEBPACK_IMPORTED_MODULE_6__["NotificationType"].Success:
                    method = this.snotifyService.error;
                    break;
                default:
                    method = this.snotifyService.error;
                    break;
            }
            method(text);
        });
    }
    resolveState(name) {
        let state = this.busyStates[name];
        if (state == null) {
            state = new BusyState();
            this.busyStates[name] = state;
        }
        return state;
    }
    waitFor(workSupplier, target = "viewport") {
        return new Promise((resolve, reject) => window.setTimeout(() => {
            const context = new WaitContext();
            const blockOn = this.resolveState(target);
            const work = workSupplier(context);
            blockOn.increment();
            work.then((payload) => {
                resolve(payload);
                blockOn.decrement();
            }).catch((error) => {
                this.handleError(error);
                reject(error);
                blockOn.decrement();
            });
        }, 1));
    }
}
UiToolkit.ɵfac = function UiToolkit_Factory(t) { return new (t || UiToolkit)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](ng_snotify__WEBPACK_IMPORTED_MODULE_2__["SnotifyService"])); };
UiToolkit.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: UiToolkit, factory: UiToolkit.ɵfac });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UiToolkit, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__["TranslateService"] }, { type: ng_snotify__WEBPACK_IMPORTED_MODULE_2__["SnotifyService"] }]; }, null); })();
class WaitContext {
}
class BusyState {
    constructor() {
        this.stackCount = 0;
        this.stateSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["Subject"]();
        this.stateObservabe = this.stateSubject.asObservable();
    }
    increment() {
        this.stackCount = this.stackCount + 1;
        this.stateSubject.next(this);
    }
    decrement() {
        this.stackCount = this.stackCount - 1;
        this.stateSubject.next(this);
    }
    get isVisible() {
        return this.stackCount > 0;
    }
}
class WaitPanelComponent {
    constructor(ui) {
        this.ui = ui;
        this.isVisible = false;
    }
    get isTotalOverlay() {
        return this.name === "viewport";
    }
    ngOnChanges(changes) {
        if (this.subscription) {
            this.subscription.unsubscribe();
        }
        this.subscription = this.ui.resolveState(this.name).stateObservabe
            .subscribe((state) => {
            this.isVisible = state.isVisible;
        });
    }
    ngOnDestroy() {
        this.subscription.unsubscribe();
    }
}
WaitPanelComponent.ɵfac = function WaitPanelComponent_Factory(t) { return new (t || WaitPanelComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](UiToolkit)); };
WaitPanelComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: WaitPanelComponent, selectors: [["wait-panel"]], inputs: { name: "name" }, features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵNgOnChangesFeature"]], ngContentSelectors: _c0, decls: 4, vars: 3, consts: [[1, "wait-panel", "wait-panel-layout"], [1, "wait-panel__content", "wait-panel-layout__content"], ["class", "wait-panel__glass wait-panel-layout__glass", 3, "is-total-overlay-state", 4, "ngIf"], [1, "wait-panel__glass", "wait-panel-layout__glass"], [1, "wait-panel-layout__front"], [1, "wait-panel-layout__area"], [1, "wait-panel-layout__separator"], [1, "wait-panel__spinner", "wait-panel-layout__spinner"], [1, "wait-panel__description", "wait-panel-layout__description"]], template: function WaitPanelComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵprojectionDef"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵprojection"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](3, WaitPanelComponent_div_3_Template, 8, 7, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassProp"]("is-total-overlay-state", ctx.isTotalOverlay);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isVisible);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_8__["NgIf"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__["TranslatePipe"]], encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](WaitPanelComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: "wait-panel",
                templateUrl: "./wait-panel.component.html"
            }]
    }], function () { return [{ type: UiToolkit }]; }, { name: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"]
        }] }); })();


/***/ }),

/***/ "JMaW":
/*!******************************************!*\
  !*** ./src/app/commons/notifications.ts ***!
  \******************************************/
/*! exports provided: NotificationType, MessageNotification */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NotificationType", function() { return NotificationType; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MessageNotification", function() { return MessageNotification; });
var NotificationType;
(function (NotificationType) {
    NotificationType[NotificationType["Information"] = 0] = "Information";
    NotificationType[NotificationType["Success"] = 1] = "Success";
    NotificationType[NotificationType["Error"] = 2] = "Error";
    NotificationType[NotificationType["Warning"] = 3] = "Warning";
})(NotificationType || (NotificationType = {}));
class MessageNotification {
    constructor(type, message, messageParameters = []) {
        this.type = type;
        this.message = message;
        this.messageParameters = messageParameters;
    }
}


/***/ }),

/***/ "RUEf":
/*!*******************************!*\
  !*** ./src/app/app.routes.ts ***!
  \*******************************/
/*! exports provided: AppRoutes */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutes", function() { return AppRoutes; });
/* harmony import */ var _app_route_paths__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./app.route.paths */ "p5LJ");
/* harmony import */ var _interaction_views_login_login_view__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./interaction/views/login/login.view */ "1ptk");
/* harmony import */ var _interaction_views_books_books_view__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./interaction/views/books/books.view */ "TUfd");



const AppRoutes = [
    {
        path: _app_route_paths__WEBPACK_IMPORTED_MODULE_0__["RoutePath"].Login,
        pathMatch: "full",
        component: _interaction_views_login_login_view__WEBPACK_IMPORTED_MODULE_1__["LoginViewComponent"]
    },
    {
        path: "**",
        pathMatch: "full",
        redirectTo: _app_route_paths__WEBPACK_IMPORTED_MODULE_0__["RoutePath"].Login
    },
    {
        path: _app_route_paths__WEBPACK_IMPORTED_MODULE_0__["RoutePath"].Books,
        pathMatch: "full",
        component: _interaction_views_books_books_view__WEBPACK_IMPORTED_MODULE_2__["BooksViewComponent"]
    },
];


/***/ }),

/***/ "Sy1n":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ngx-translate/core */ "sYmb");
/* harmony import */ var ng_snotify__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ng-snotify */ "90Zs");
/* harmony import */ var _toolkit_ui_toolkit__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./toolkit/ui-toolkit */ "H07S");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "tyNb");






class AppComponent {
    constructor(translate) {
        translate.setDefaultLang("en");
        translate.use("en");
    }
}
AppComponent.ɵfac = function AppComponent_Factory(t) { return new (t || AppComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslateService"])); };
AppComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: AppComponent, selectors: [["app-root"]], decls: 4, vars: 0, consts: [["name", "viewport"]], template: function AppComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "ng-snotify");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "wait-panel", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](3, "router-outlet");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
    } }, directives: [ng_snotify__WEBPACK_IMPORTED_MODULE_2__["SnotifyComponent"], _toolkit_ui_toolkit__WEBPACK_IMPORTED_MODULE_3__["WaitPanelComponent"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterOutlet"]], encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: "app-root",
                templateUrl: "./app.component.html",
            }]
    }], function () { return [{ type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslateService"] }]; }, null); })();


/***/ }),

/***/ "TUfd":
/*!*******************************************************!*\
  !*** ./src/app/interaction/views/books/books.view.ts ***!
  \*******************************************************/
/*! exports provided: BooksViewComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BooksViewComponent", function() { return BooksViewComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _toolkit_ui_toolkit__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../../toolkit/ui-toolkit */ "H07S");



class BooksViewComponent {
    constructor(ui) {
        this.ui = ui;
    }
}
BooksViewComponent.ɵfac = function BooksViewComponent_Factory(t) { return new (t || BooksViewComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_toolkit_ui_toolkit__WEBPACK_IMPORTED_MODULE_1__["UiToolkit"])); };
BooksViewComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: BooksViewComponent, selectors: [["books"]], decls: 1, vars: 0, template: function BooksViewComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](0, "BOOKs");
    } }, encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](BooksViewComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: "books",
                templateUrl: "./books.view.html"
            }]
    }], function () { return [{ type: _toolkit_ui_toolkit__WEBPACK_IMPORTED_MODULE_1__["UiToolkit"] }]; }, null); })();


/***/ }),

/***/ "ZAI4":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: HttpLoaderFactory, AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HttpLoaderFactory", function() { return HttpLoaderFactory; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "jhN1");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "tk/3");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "sYmb");
/* harmony import */ var _ngx_translate_http_loader__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ngx-translate/http-loader */ "mqiu");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "tyNb");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ "3Pt+");
/* harmony import */ var ng_snotify__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ng-snotify */ "90Zs");
/* harmony import */ var angular_svg_icon__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! angular-svg-icon */ "OFbc");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./app.component */ "Sy1n");
/* harmony import */ var _interaction_interactions_module__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./interaction/interactions.module */ "ELJf");
/* harmony import */ var _app_routes__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./app.routes */ "RUEf");
/* harmony import */ var _toolkit_ui_toolkit_module__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./toolkit/ui-toolkit.module */ "G/O7");
/* harmony import */ var _gateways_gateways_module__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./gateways/gateways.module */ "gDtb");



















// AoT requires an exported function for factories
function HttpLoaderFactory(http) {
    return new _ngx_translate_http_loader__WEBPACK_IMPORTED_MODULE_4__["TranslateHttpLoader"](http);
}
class AppModule {
}
AppModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineNgModule"]({ type: AppModule, bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"]] });
AppModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineInjector"]({ factory: function AppModule_Factory(t) { return new (t || AppModule)(); }, providers: [
        ng_snotify__WEBPACK_IMPORTED_MODULE_7__["SnotifyService"],
        { provide: "SnotifyToastConfig", useValue: ng_snotify__WEBPACK_IMPORTED_MODULE_7__["ToastDefaults"] },
    ], imports: [[
            _angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormsModule"],
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClientModule"],
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateModule"].forRoot({
                loader: {
                    provide: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateLoader"],
                    useFactory: HttpLoaderFactory,
                    deps: [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]]
                }
            }),
            _angular_router__WEBPACK_IMPORTED_MODULE_5__["RouterModule"].forRoot(_app_routes__WEBPACK_IMPORTED_MODULE_11__["AppRoutes"]),
            ng_snotify__WEBPACK_IMPORTED_MODULE_7__["SnotifyModule"].forRoot(),
            angular_svg_icon__WEBPACK_IMPORTED_MODULE_8__["AngularSvgIconModule"].forRoot(),
            // UI Toolkit
            _toolkit_ui_toolkit_module__WEBPACK_IMPORTED_MODULE_12__["UiToolkitModule"],
            // application
            _interaction_interactions_module__WEBPACK_IMPORTED_MODULE_10__["InteractionsModule"],
            _gateways_gateways_module__WEBPACK_IMPORTED_MODULE_13__["GatewaysModule"]
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsetNgModuleScope"](AppModule, { declarations: [_app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"]], imports: [_angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormsModule"],
        _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
        _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClientModule"], _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateModule"], _angular_router__WEBPACK_IMPORTED_MODULE_5__["RouterModule"], ng_snotify__WEBPACK_IMPORTED_MODULE_7__["SnotifyModule"], angular_svg_icon__WEBPACK_IMPORTED_MODULE_8__["AngularSvgIconModule"], 
        // UI Toolkit
        _toolkit_ui_toolkit_module__WEBPACK_IMPORTED_MODULE_12__["UiToolkitModule"],
        // application
        _interaction_interactions_module__WEBPACK_IMPORTED_MODULE_10__["InteractionsModule"],
        _gateways_gateways_module__WEBPACK_IMPORTED_MODULE_13__["GatewaysModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵsetClassMetadata"](AppModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"],
        args: [{
                declarations: [
                    _app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"]
                ],
                imports: [
                    _angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormsModule"],
                    _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                    _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClientModule"],
                    _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateModule"].forRoot({
                        loader: {
                            provide: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateLoader"],
                            useFactory: HttpLoaderFactory,
                            deps: [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]]
                        }
                    }),
                    _angular_router__WEBPACK_IMPORTED_MODULE_5__["RouterModule"].forRoot(_app_routes__WEBPACK_IMPORTED_MODULE_11__["AppRoutes"]),
                    ng_snotify__WEBPACK_IMPORTED_MODULE_7__["SnotifyModule"].forRoot(),
                    angular_svg_icon__WEBPACK_IMPORTED_MODULE_8__["AngularSvgIconModule"].forRoot(),
                    // UI Toolkit
                    _toolkit_ui_toolkit_module__WEBPACK_IMPORTED_MODULE_12__["UiToolkitModule"],
                    // application
                    _interaction_interactions_module__WEBPACK_IMPORTED_MODULE_10__["InteractionsModule"],
                    _gateways_gateways_module__WEBPACK_IMPORTED_MODULE_13__["GatewaysModule"]
                ],
                providers: [
                    ng_snotify__WEBPACK_IMPORTED_MODULE_7__["SnotifyService"],
                    { provide: "SnotifyToastConfig", useValue: ng_snotify__WEBPACK_IMPORTED_MODULE_7__["ToastDefaults"] },
                ],
                bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "epUv":
/*!***********************************!*\
  !*** ./src/app/commons/errors.ts ***!
  \***********************************/
/*! exports provided: ValidationError */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ValidationError", function() { return ValidationError; });
class ValidationError extends Error {
    constructor(result) {
        super();
        this.result = result;
    }
    reasons() {
        return this.result.reasons();
    }
}


/***/ }),

/***/ "gDtb":
/*!*********************************************!*\
  !*** ./src/app/gateways/gateways.module.ts ***!
  \*********************************************/
/*! exports provided: GatewaysModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GatewaysModule", function() { return GatewaysModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _authentication_gateway__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./authentication-gateway */ "+WAi");



class GatewaysModule {
}
GatewaysModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: GatewaysModule });
GatewaysModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function GatewaysModule_Factory(t) { return new (t || GatewaysModule)(); }, providers: [
        _authentication_gateway__WEBPACK_IMPORTED_MODULE_1__["AuthenticationGateway"]
    ] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GatewaysModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                providers: [
                    _authentication_gateway__WEBPACK_IMPORTED_MODULE_1__["AuthenticationGateway"]
                ]
            }]
    }], null, null); })();


/***/ }),

/***/ "p5LJ":
/*!************************************!*\
  !*** ./src/app/app.route.paths.ts ***!
  \************************************/
/*! exports provided: RoutePath */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RoutePath", function() { return RoutePath; });
var RoutePath;
(function (RoutePath) {
    RoutePath["Login"] = "login";
    RoutePath["Books"] = "books";
})(RoutePath || (RoutePath = {}));


/***/ }),

/***/ "zUnb":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./environments/environment */ "AytR");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "ZAI4");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser */ "jhN1");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
_angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["platformBrowser"]().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(err => console.error(err));


/***/ }),

/***/ "zn8P":
/*!******************************************************!*\
  !*** ./$$_lazy_route_resource lazy namespace object ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "zn8P";

/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map