package com.github.blindpirate.gogradle.core.pack;

import com.github.blindpirate.gogradle.vcs.VcsType;

import java.util.Arrays;
import java.util.List;

public class PackageInfo {
    // the package name can be recognized, but it's incomplete, e.g. "github.com/a"
    public static final PackageInfo INCOMPLETE =
            builder().withName("INCOMPLETE").build();

    private String name;
    private VcsType vcsType;
    private List<String> urls;
    // the import path corresponding to the repository root
    private String rootName;
    private boolean standard;

    public String getName() {
        return name;
    }

    public VcsType getVcsType() {
        return vcsType;
    }

    public List<String> getUrls() {
        return urls;
    }

    public String getRootName() {
        return rootName;
    }

    public boolean isStandard() {
        return standard;
    }

    public static PackageInfoBuilder builder() {
        return new PackageInfoBuilder();
    }

    public static PackageInfo standardPackage(String packageName) {
        PackageInfo info = new PackageInfo();
        info.standard = true;
        info.name = packageName;
        return info;
    }


    public static final class PackageInfoBuilder {
        private String name;
        private VcsType vcsType;
        private List<String> urls;
        private String rootName;

        public PackageInfoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PackageInfoBuilder withVcsType(VcsType vcsType) {
            this.vcsType = vcsType;
            return this;
        }

        public PackageInfoBuilder withUrls(List<String> urls) {
            this.urls = urls;
            return this;
        }

        public PackageInfoBuilder withUrl(String url) {
            this.urls = Arrays.asList(url);
            return this;
        }

        public PackageInfoBuilder withRootName(String rootName) {
            this.rootName = rootName;
            return this;
        }

        public PackageInfo build() {
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.urls = this.urls;
            packageInfo.rootName = this.rootName;
            packageInfo.name = this.name;
            packageInfo.vcsType = this.vcsType;
            return packageInfo;
        }
    }
}
