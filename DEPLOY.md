# Deploy Portfolio to GitHub Pages

## Step 1: Create GitHub Repository

1. Go to [GitHub](https://github.com) and sign in
2. Click the **"+"** icon in the top right → **"New repository"**
3. Repository name: `portfolio` or `tshifhiwa-portfolio` (or any name you prefer)
4. Description: "Professional portfolio website"
5. Make it **Public** (required for free GitHub Pages)
6. **DO NOT** initialize with README, .gitignore, or license (we already have these)
7. Click **"Create repository"**

## Step 2: Push Your Code

After creating the repository, GitHub will show you commands. Use these:

```bash
cd portfolio
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
git branch -M main
git push -u origin main
```

Replace:
- `YOUR_USERNAME` with your GitHub username (e.g., `TshifhiwaRamukhadi`)
- `YOUR_REPO_NAME` with your repository name (e.g., `portfolio`)

## Step 3: Enable GitHub Pages

1. Go to your repository on GitHub
2. Click **Settings** (top menu)
3. Scroll down to **Pages** (left sidebar)
4. Under **Source**, select **"Deploy from a branch"**
5. Branch: **main** → **/ (root)**
6. Click **Save**

## Step 4: Access Your Portfolio

Your portfolio will be live at:
**https://YOUR_USERNAME.github.io/YOUR_REPO_NAME/**

For example: `https://tshifhiwaramukhadi.github.io/portfolio/`

⏱️ It may take a few minutes for the site to be available after enabling Pages.

## Troubleshooting

- If CSS doesn't load, make sure all file paths are relative (they should be)
- Clear browser cache: Ctrl+F5
- Check repository Settings → Pages to ensure it's enabled

