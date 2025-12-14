<!-- Auto-generated guidance for AI coding agents in this repository -->
# Copilot / AI Agent Instructions

**Purpose**: Help AI coding agents be productive quickly in this Create React App frontend.

**Quick Setup**
- **Install / Run:** `npm install` then `npm start` (development) or `npm run build` (production). See [package.json](package.json#L1-L40).

**Big Picture**
- **Type:** Single-page React app bootstrapped with Create React App.
- **UI:** Components live in `src/` (e.g. [src/App.js](src/App.js#L1-L40), [src/pages/Login.js](src/pages/Login.js#L1-L120)).
- **Styles:** Per-component CSS files (e.g. [src/pages/Login.css](src/pages/Login.css#L1)).
- **API surface:** All HTTP calls use the shared axios instance at [src/api/axiosConfig.js](src/api/axiosConfig.js#L1-L40). Base URL is `http://localhost:9090`.

**Architectural patterns & critical flows**
- **Auth token flow:** Backend returns a JWT at `/api/auth/login` and frontend stores it in `localStorage` under key `token` (see [src/pages/Login.js](src/pages/Login.js#L1-L40) and [src/api/axiosConfig.js](src/api/axiosConfig.js#L1-L30)).
- **Request interception:** `src/api/axiosConfig.js` adds `Authorization: Bearer <token>` to outgoing requests when `localStorage.token` exists — modify here to change global auth behavior.
- **API paths:** Calls are made against `/api/...` (the API gateway/express backend expected at localhost:9090 during development).

**Developer workflows / commands**
- `npm start` — runs CRA dev server on `http://localhost:3000`.
- `npm run build` — produces production bundle in `build/`.
- `npm test` — runs CRA tests.
- When debugging API issues, confirm backend is running at `http://localhost:9090` and CORS is enabled.

**Project-specific conventions**
- **Single axios instance:** Always import `src/api/axiosConfig.js` (named `api`) instead of creating ad-hoc axios instances.
- **Token storage:** Use `localStorage.getItem('token')`/`setItem('token', token)` consistent with existing code.
- **CSS location:** Keep simple presentational styles in `*.css` alongside components rather than switching to CSS-in-JS.
- **Error handling:** Current pattern surfaces login errors to a local `error` state and shows an inline message — follow similar small-state error patterns for form components.

**Files to inspect for changes or extension**
- Authentication flow: [src/pages/Login.js](src/pages/Login.js#L1-L120)
- Global HTTP config & auth header: [src/api/axiosConfig.js](src/api/axiosConfig.js#L1-L40)
- App scaffold / entry: [src/App.js](src/App.js#L1-L40) and [src/index.js](src/index.js#L1-L80)
- Build & dev scripts: [package.json](package.json#L1-L40)

**When editing code**
- Prefer minimal, targeted changes; keep CRA defaults unless there's a clear reason to eject.
- If adding new API calls, reuse `api` from `src/api/axiosConfig.js` and follow `/api/...` path convention.
- Add or update component-level CSS files in `src/` and import them at the top of the component file.

**Testing & verification**
- Manual dev verification: `npm start` then exercise the UI in the browser at `http://localhost:3000` and confirm API requests hit `http://localhost:9090`.
- Unit tests: use `npm test`. There is no test harness beyond CRA defaults in the repo.

**Known assumptions & limits (do not invent)**
- Backend base URL is configured to `http://localhost:9090` in `src/api/axiosConfig.js`; do not assume a different backend without explicit change.
- Routing is minimal / absent in the current scaffold — add `react-router` only if you update the app's navigation and update README accordingly.

If anything above is unclear or you want the file to be stricter/looser (e.g., add code style rules, linting setup, or CI instructions), tell me what to include and I'll iterate.
